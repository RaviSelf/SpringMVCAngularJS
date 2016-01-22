package com.springapp.mvc.repository.jpa;

import com.springapp.mvc.modal.UserRoles;
import com.springapp.mvc.modal.Users;
import com.springapp.mvc.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by Ravi on 08/11/15.
 *
 *
 * https://quikview.internal.t-mobile.com/UUI_LiveCycle/branches/BR_3.31
 **/

@Repository
public class UserJPAImpl  implements UserRepository{

    @PersistenceContext
    private EntityManager em;

    private static Logger logger = LoggerFactory.getLogger(UserJPAImpl.class);

    @Override
    public void addUser(UserRoles userRoles) throws DataAccessException {
        try{
            if(userRoles.getId() == null){
                /* em = em.getEntityManagerFactory().createEntityManager();
                Session session = (Session) em.unwrap(Session.class);*/
                userRoles.setTransactionDate(new Date());
                // this is Temp fix for createdBy, TODO--> Based on admin Login
                if(userRoles.getCreatedBy() == null)
                {
                    userRoles.setCreatedBy("damarlaravi@gmail.com");
                    userRoles.setRole("ADMIN");
                }
                if(userRoles.getUsers() != null)
                {
                    String password = userRoles.getUsers().getPassword();
                    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    String hashedPassword = passwordEncoder.encode(password);
                    userRoles.getUsers().setPassword(hashedPassword);
                    logger.info(" user Encrypted Password", hashedPassword);
                }

                em.persist(userRoles);
                //Here the TransactionRequiredException happens.
                em.flush();
            }
            else
            {
                em.merge(userRoles);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isUserAvailable(Users users) throws DataAccessException {
        List<Users> allUserses = getAvailableUsers();
        Authentication request = new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword());
        //Authentication result = authenticationManager.authenticate(request);
        //SecurityContextHolder.getContext().setAuthentication(result);
        System.out.print(allUserses);
        return false;
    }

    public List<Users> getAvailableUsers(){
        return em.createQuery("select users from Users users", Users.class).getResultList();
    }
}

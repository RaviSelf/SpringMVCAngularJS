package com.springapp.mvc.repository.jpa;

import com.springapp.mvc.modal.Member;
import com.springapp.mvc.repository.MemberRepository;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by rdemarla on 30-Oct-15.
 **/

@Repository
public class MemberJPAImpl implements MemberRepository {
    //private Logger logger =

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addMember(Member member) {
        try {
            List<Member> members = getMembers();
            if (member.getId() == null) {

               /* em = em.getEntityManagerFactory().createEntityManager();
                Session session = (Session) em.unwrap(Session.class);*/

                em.persist(member);
                //Here the TransactionRequiredException happens.
                em.flush();

            } else {
                em.merge(member);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private List<Member> getMembers() {
        return em.createQuery("select mem from Member mem", Member.class).getResultList();
    }
}

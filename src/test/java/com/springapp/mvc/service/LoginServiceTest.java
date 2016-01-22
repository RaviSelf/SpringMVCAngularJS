package com.springapp.mvc.service;

import com.springapp.mvc.modal.UserRoles;
import com.springapp.mvc.modal.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by rdemarla on 09-Nov-15.
 **/

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jpa")
public class LoginServiceTest extends AbstractTestService
{
    @Autowired
    protected MainService mainService;

    @Test
    @Transactional
    public void insertUser()
    {
        UserRoles userRoles = new UserRoles();
        Users user = new Users();
        userRoles.setFirstName("Ravi Kumar");
        userRoles.setLastName("Demarla");
        user.setUsername("damrlaravi@gmail.com");
        user.setEnabled(1);
        user.setPassword("damrlaravi");
        userRoles.setRole("ROLE_ADMIN");
        userRoles.setTransactionDate(new Date());
        mainService.addUser(userRoles);
    }
}

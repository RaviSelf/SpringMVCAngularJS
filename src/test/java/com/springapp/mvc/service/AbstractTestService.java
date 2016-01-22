package com.springapp.mvc.service;

import com.springapp.mvc.modal.Address;
import com.springapp.mvc.modal.Member;
import com.springapp.mvc.modal.UserRoles;
import com.springapp.mvc.modal.Users;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by rdemarla on 02-Nov-15.
 **/

public abstract class AbstractTestService
{
    @Autowired
    protected MainService mainService;

    @Test
    @Transactional
    public void insertMember()
    {
        Member member = new Member();
        Address address = new Address();
        member.setTransactionDate(new Date());
        member.setFirstName("Ravi");
        member.setLastName("Kumar");
        member.setRole("President");
        member.setGender("Male");
        member.setPhoneNumber("7799557456");
        member.setEmail("damarlaravi@gmail.com");
        address.setAddress1("#12-254");
        address.setAddress2("");
        address.setCity("Kalwakurthy");
        address.setState("Telangana");
        address.setStreet("");
        address.setPinCode("509324");
        member.setAddress(address);

        this.mainService.addMember(member);

        //assertNotNull("Pet Id should have been generated", member.getId());
    }

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

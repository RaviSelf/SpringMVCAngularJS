package com.springapp.mvc.web;

import com.springapp.mvc.modal.UserRoles;
import com.springapp.mvc.modal.Users;
import com.springapp.mvc.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Ravi on 07/11/15.
 **/

@Transactional
@Controller
public class LoginController
{
    private final MainService mainService;

    @Autowired
    public LoginController(MainService service){
        this.mainService = service;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean userLogin(@RequestBody Users users){
        return mainService.isUserAvailable(users);
    }


    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public void addUser(@RequestBody UserRoles userRoles, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return;
        }
        mainService.addUser(userRoles);
    }
}

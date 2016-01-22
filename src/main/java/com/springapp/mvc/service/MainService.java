package com.springapp.mvc.service;

import com.springapp.mvc.modal.Member;
import com.springapp.mvc.modal.UserRoles;
import com.springapp.mvc.modal.Users;

/**
 * Created by rdemarla on 30-Oct-15.
 **/

public interface MainService {
    void addMember(Member member);

    boolean isUserAvailable(Users users);

    void addUser(UserRoles users);
}

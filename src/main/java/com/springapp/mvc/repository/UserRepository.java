package com.springapp.mvc.repository;

import com.springapp.mvc.modal.UserRoles;
import com.springapp.mvc.modal.Users;
import org.springframework.dao.DataAccessException;

/**
 * Created by Ravi on 08/11/15.
 **/

public interface UserRepository {
    void addUser(UserRoles userRoles) throws DataAccessException;
    boolean isUserAvailable(Users users) throws DataAccessException;
}

package com.springapp.mvc.modal;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ravi on 07/11/15.
 **/
@Entity
@Table(name = "USERS")
public class Users
{
    @Id
    @Column(name = "USERNAME", nullable = false)
    public String username;

    @Column(name = "PASSWORD", nullable = false)
    public String password;

    @Column(name = "ENABLED")
    public int enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}

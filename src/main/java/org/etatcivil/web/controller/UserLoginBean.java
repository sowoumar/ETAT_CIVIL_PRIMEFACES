package org.etatcivil.web.controller;

import org.etatcivil.dto.UserDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


public class UserLoginBean {

    private String username;

    private String password;

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

}
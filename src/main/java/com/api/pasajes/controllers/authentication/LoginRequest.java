package com.api.pasajes.controllers.authentication;

public class LoginRequest {

    private String userName;
    private String password;

    public LoginRequest(){}

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

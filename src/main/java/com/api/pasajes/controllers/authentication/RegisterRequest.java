package com.api.pasajes.controllers.authentication;

public class RegisterRequest {

    private String userName;
    private String password;

    public RegisterRequest(){}

    public RegisterRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}

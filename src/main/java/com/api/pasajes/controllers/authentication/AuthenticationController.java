package com.api.pasajes.controllers.authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {

    @GetMapping(value = "/login")
    public String loggin(){
        return "Loggin";
    }

    @PostMapping(value = "register")
    public String registro(){
        return "Registrarce";
    }
}

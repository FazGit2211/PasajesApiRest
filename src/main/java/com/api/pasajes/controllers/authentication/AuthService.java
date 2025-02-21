package com.api.pasajes.controllers.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.api.pasajes.jwt.JwtService;
import com.api.pasajes.models.User;
import com.api.pasajes.repositorys.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    private final AuthenticationManager authenticationManager = null;

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        UserDetails user = userRepository.findByUserName(request.getUserName()).get();
        String token = jwtService.getToken(user);
        AuthResponse authResponse = new AuthResponse(token);
        return authResponse; 
    }

    public AuthResponse register(RegisterRequest request){
        User user = new User(request.getUserName(), request.getPassword() );
        userRepository.save(user);
        String token = jwtService.getToken(user);
        AuthResponse authResponse = new AuthResponse(token);
        return authResponse;
    }
}

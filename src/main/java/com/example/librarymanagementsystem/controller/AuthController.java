package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.config.JwtAuthenticationFilter;
import com.example.librarymanagementsystem.dto.LoginRequest;
import com.example.librarymanagementsystem.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest authenticationRequest) {
        try {
            LoginResponse authResponse = jwtAuthenticationFilter.authenticate(authenticationRequest);

            System.out.println("username: " + authenticationRequest.getUsername());
            System.out.println("jwt token: " + authResponse.getAccessToken());

            return ResponseEntity.ok(authResponse);
        } catch (AuthenticationServiceException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

//    @GetMapping("/welcome")
//    public ResponseEntity<String> welcome() {
//        return ResponseEntity.ok("Welcome to the Stage 1 application!");
//    }

}
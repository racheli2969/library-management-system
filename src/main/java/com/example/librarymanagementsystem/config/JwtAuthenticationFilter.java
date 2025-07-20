package com.example.librarymanagementsystem.config;

import com.example.librarymanagementsystem.dto.LoginRequest;
import com.example.librarymanagementsystem.dto.LoginResponse;
import com.example.librarymanagementsystem.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtAuthenticationFilter {

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    /**
     * The authenticate() method takes in an AuthenticationRequest object,
     * which contains the username and password.
     * The method returns an AuthenticationResponse object,
     * which contains the JWT token.
     */
    public LoginResponse authenticate(LoginRequest authenticationRequest) {
        // Load the user details from the database
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                authenticationRequest.getUsername());

        // Check if the password matches
        if (!passwordEncoder.matches(authenticationRequest.getPassword(), userDetails.getPassword())) {
            throw new AuthenticationServiceException("Invalid credentials");
        }

        // Generate the JWT token
        String jwtToken = jwtUtil.generateToken(userDetails);

        // Return the AuthenticationResponse object
        return new LoginResponse(jwtToken);
    }
}
package com.example.librarymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The LoginResponse class is used to store the access token
 * It is used in the authentication controller for login
 * if the user is logged in then it is authorized
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String accessToken;
}


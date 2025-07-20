package com.example.librarymanagementsystem.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RoleDto {
    @NotBlank(message = "Username must not be blank")
    @Size(min = 2, max = 50, message = "Username must be between 3 and 30 characters")
    private String roleName;
}

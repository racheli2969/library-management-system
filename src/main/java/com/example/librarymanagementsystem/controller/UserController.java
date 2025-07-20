package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.dto.StandardResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserController userService;
    // Assign role to user
    @PostMapping("/{username}/roles/{roleId}")
    public ResponseEntity<StandardResponse> assignRoleToUser(
            @PathVariable String username,
            @PathVariable Long roleId) {

        return ResponseEntity.ok(
                new StandardResponse(
                        "success",
                        userService.assignRoleToUser(username, roleId),
                        null
                )
        );
    }

    // ...
}
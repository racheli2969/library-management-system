package com.example.librarymanagementsystem.exceptions;

import com.example.librarymanagementsystem.dto.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("type", "Resource Not Found");
        error.put("message", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new StandardResponse("error", null, error));
    }

    @ExceptionHandler(ResourceConflictException.class)
    public ResponseEntity<StandardResponse> handleResourceNotFoundException(ResourceConflictException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("type", "Resource Conflict");
        error.put("message", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new StandardResponse("error", null, error));
    }

    // ...
}
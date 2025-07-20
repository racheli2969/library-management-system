package com.example.librarymanagementsystem.exceptions;

public  class ResourceNotFoundException extends RuntimeException {
    private ResourceNotFoundException(String message) {
       super(message);
    }
    public static @org.jetbrains.annotations.NotNull RuntimeException createForUser(String userName) {
       return new ResourceNotFoundException("user with username " + userName + " not found");
    }

    public static @org.jetbrains.annotations.NotNull RuntimeException createForRole(Long roleId) {
        return new ResourceNotFoundException("role with id " + roleId + " not found");
    }
}

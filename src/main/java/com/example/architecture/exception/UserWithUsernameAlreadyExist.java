package com.example.architecture.exception;

public class UserWithUsernameAlreadyExist extends RuntimeException {
    String message;

    public UserWithUsernameAlreadyExist(String message) {
        this.message = message;
    }
}

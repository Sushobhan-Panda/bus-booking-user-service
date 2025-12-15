package com.bus.user.exception;

//This is a custom exception class
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

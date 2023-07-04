package com.apper.estore;

public class InvalidUserAgeException extends Exception{
    private String message;
    public InvalidUserAgeException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

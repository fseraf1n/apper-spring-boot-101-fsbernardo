package com.apper.estore;

public class ServiceError extends RuntimeException{

    private String message;
    public ServiceError(String message) {
        this.message = message;
    }


}

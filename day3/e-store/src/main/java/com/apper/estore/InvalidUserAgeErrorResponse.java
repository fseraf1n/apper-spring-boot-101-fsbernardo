package com.apper.estore;

import lombok.Data;

@Data
public class InvalidUserAgeErrorResponse {
    private String message;

    public InvalidUserAgeErrorResponse(String message) {
        this.message = message;
    }

}

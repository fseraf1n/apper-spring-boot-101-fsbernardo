package com.apper;

import lombok.Data;

@Data
public class UpdateAccountRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}

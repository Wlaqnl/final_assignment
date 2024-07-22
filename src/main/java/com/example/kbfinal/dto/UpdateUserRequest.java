package com.example.kbfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateUserRequest {
    private String username;
    private String password;
    private String address;
    private String birthday;
    private String email;

}

package com.example.kbfinal.dto;

import com.example.kbfinal.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {
    private String username;
    private String password;
    private String address;
    private String birthday;
    private String email;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .address(address)
                .birthday(birthday)
                .email(email)
                .build();
    }
}

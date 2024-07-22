package com.example.kbfinal.dto;

import com.example.kbfinal.entity.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private final Long id;
    private final String username;
    private final String password;
    private final String address;
    private final String birthday;
    private final String email;

    public UserResponse(User user){
        this.id = user.getId();
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.address=user.getAddress();
        this.birthday=user.getBirthday();
        this.email=user.getEmail();
    }

}

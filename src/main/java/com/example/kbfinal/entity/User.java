package com.example.kbfinal.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok 사용할것
@Entity
@Data
@Table(name="user_table")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false) // Not null
    private String password;

    // 추가로 3개의 attribute 를 만들기
    @Column(name = "address")
    private String address;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "email")
    private String email;

    @Builder
    public User(String username, String password, String address, String birthday, String email){
        this.username = username;
        this.password = password;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public void update(String username, String password, String address, String birthday, String email){
        this.username = username;
        this.password = password;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

}

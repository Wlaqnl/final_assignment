package com.example.kbfinal.controller;

import com.example.kbfinal.dto.AddUserRequest;
import com.example.kbfinal.dto.AuthUserRequest;
import com.example.kbfinal.dto.UpdateUserRequest;
import com.example.kbfinal.dto.UserResponse;
import com.example.kbfinal.entity.User;
import com.example.kbfinal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    // user 정보를 입력하는 API 생성
    @PostMapping("/api/users")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request){
        System.out.println("user 생성하기");
        User savedUser = userService.registerUser(request.toEntity());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    // user 정보 수정하는 api 생성
    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UpdateUserRequest request){
        User updatedUser = userService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedUser);
    }

    // user 정보 삭제하는 api 생성
    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id){
        userService.delete(id);
        return ResponseEntity.ok()
                .build();
    }

    // 전체 user List를 조회하는 api 생성
    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponse>> findAllUsers() {

        List<UserResponse> users = userService.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(users);
    }

    // 전체 user 의 숫자를 조회하는 api 생성
    @GetMapping("/api/allusers")
    public ResponseEntity<Long> countAllUsers(){
        Long users = userService.countUser();
        System.out.println("users : " + users);
        return ResponseEntity.ok()
                .body(users);
    }

    // user 인증
    @PostMapping("/api/authusers")
    public boolean authUsers(@RequestBody AuthUserRequest request){
        System.out.println("유저 인증하기");
        String username = request.getUsername();
        String password = request.getPassword();
        boolean result = userService.authenticate(username,password);
        return result;
    }
}

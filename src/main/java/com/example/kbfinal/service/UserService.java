package com.example.kbfinal.service;

import com.example.kbfinal.dto.UpdateUserRequest;
import com.example.kbfinal.entity.User;
import com.example.kbfinal.exception.KbFinalException;
import com.example.kbfinal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.kbfinal.exception.KbFinalErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    // 유저 생성
    public User registerUser(User user) {
        // 비밀번호를 암호화하여 저장
        // password를 인코딩
        // user entity에 인코딩 된 password를 넣기
        String rawPassword = user.getPassword();
        System.out.println("rawPassword : " + rawPassword);
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("encodedPassword : " + encodedPassword);
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    @Transactional
    // 유저 정보 수정
    public User update(long id, UpdateUserRequest request){
        User user = userRepository.findById(id)
                //.orElseThrow(() -> new IllegalArgumentException("not found : " + id));
                .orElseThrow(() -> new KbFinalException(USER_NOT_FOUND)); //global exception 처리

        user.update(request.getUsername(), request.getPassword(), request.getAddress(), request.getBirthday(), request.getEmail());
        return user;
    }


    // 유저 정보 삭제
    public void delete(long id){
        userRepository.findById(id)
                .orElseThrow(() -> new KbFinalException(USER_NOT_FOUND)); //global exception 처리
        userRepository.deleteById(id);

    }


    // 이후 컨트롤러에서 들어오게 될  내용 추가 구현하기
    // 유저 전체 조회
    public List<User> findAll() {
        System.out.println("UserService findAll()");
        return userRepository.findAll();
    }


    // 전체 유저 수 조회
    public Long countUser(){
        return userRepository.countUsersBy();
    }

    // 유저 인증
    public boolean authenticate(String username, String password) {
        System.out.println("username : " + username);
        System.out.println("password : " + password);

        // 사용자 조회
        User user = userRepository.findByUsername(username); // 직접 repo에서 구현
        if (user == null) {
            return false;
        }
        // 입력된 비밀번호와 저장된 암호화된 비밀번호를 비교
        return passwordEncoder.matches(password, user.getPassword());
    }
}

package com.example.myboard.service;


import com.example.myboard.dto.UserDto;
import com.example.myboard.model.User;
import com.example.myboard.model.UserRoleEnum;
import com.example.myboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    //회원가입 시, 유효성 체크
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s",error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }

    //회원가입
    public void signUp(UserDto userDto) {
        String username = userDto.getUsername();

        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);

        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(userDto.getPassword());
        UserRoleEnum role = UserRoleEnum.USER;

        User user = new User(username, password, role);
        userRepository.save(user);
    }
}
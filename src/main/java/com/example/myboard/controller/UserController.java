package com.example.myboard.controller;

import com.example.myboard.dto.UserDto;
import com.example.myboard.service.KakaoUserService;
import com.example.myboard.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@Valid UserDto userDto, Errors errors, Model model) {
        if(errors.hasErrors()) {
            
            //회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("userDto",userDto);

            //유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for(String key: validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            return "signup";
        }

        if(!userDto.getPassword().equals(userDto.getPassword2())) {
            model.addAttribute("passwordMismatch", "비밀번호를 확인해주세요.");
            return "signup";
        }

        try {
            userService.signUp(userDto);

        }catch ( Exception e ) {
            model.addAttribute("exceptionMsg",e.getMessage());
            return "signup";
        }

        return "redirect:/user/login";
    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/";
    }
}
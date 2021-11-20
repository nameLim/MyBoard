package com.example.myboard.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "닉네임은 필수 입력값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{3,20}$", message = "영문과 숫자 필수 포함 사용가능 3-20자")
    private String username;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,20}$", message = "영문과 숫자 필수 포함, 특수문자(!@#$%^&*) 사용가능 4-20자")
    private String password;

    private String password2="";


    @Builder
    public UserDto(String username, String password, String password2) {
        this.username = username;
        this.password = password;
        this.password2 = password2;
    }
}
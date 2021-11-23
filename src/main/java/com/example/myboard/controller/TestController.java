package com.example.myboard.controller;

import com.example.myboard.dto.FrontRequestCardDto;
import com.example.myboard.dto.FrontResponseCardDto;
import com.example.myboard.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final MypageService mypageService;

    @GetMapping("/test")
    public String test() {
        String testStr = ";테스트1의 결과_MyBoard";
        System.out.println(testStr);
        return testStr;
    }

    @PostMapping("/test2")
    public String test2(@ModelAttribute FrontRequestCardDto frontRequestCardDto) throws IOException {
        mypageService.modifyFrontCard(frontRequestCardDto);
        String testStr = "이미지 테스트용 컨트롤러_";
        System.out.println(testStr);
        return testStr;
    }

}

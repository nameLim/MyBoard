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

@RestController
@RequiredArgsConstructor
public class TestController {

    private MypageService mypageService;

    @GetMapping("/test")
    public String test() {
        String testStr = "application.properies 2변경3";
        System.out.println(testStr);
        return testStr;
    }

    @PostMapping("/test2")
    public FrontResponseCardDto test2(@ModelAttribute FrontRequestCardDto frontRequestCardDto) throws IOException {
        return mypageService.modifyFrontCard(frontRequestCardDto);
    }
}

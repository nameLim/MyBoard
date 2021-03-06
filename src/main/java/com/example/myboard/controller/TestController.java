package com.example.myboard.controller;

import com.example.myboard.dto.FrontRequestCardDto;
import com.example.myboard.dto.FrontResponseCardDto;
import com.example.myboard.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class TestController {

    @Value("${logging.module.version}")
    String version;

    @Value("${logging.module.version2}")
    String version2;

    private final MypageService mypageService;

    @GetMapping("/test")
    public String test() {
        String testStr = ";테스트1의 결과_무중단 테스트 중2";
        System.out.println(testStr);
        return testStr;
    }

    @PostMapping("/test2")
    public String test2(@ModelAttribute FrontRequestCardDto frontRequestCardDto) throws IOException {
        mypageService.modifyFrontCard(frontRequestCardDto);
        String testStr = "이미지 테스트용 컨트롤러__";
        System.out.println(testStr);
        return testStr;
    }

    @GetMapping("/autoPushTest")
    public String autoPushTest() throws Exception
    {
        System.out.println("version : rr  " +  version);
        System.out.println("version2 : " + version2);

        return String.format("Project Version : %s", version);
    }

    @GetMapping("/health")
    public String checkHealth() {
        return "healthy자동배포 확인222222";
    }
}

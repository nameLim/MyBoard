package com.example.myboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        String testStr = "RDS 체크 배포";
        System.out.println(testStr);
        return testStr;
    }
}

package com.example.myboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        String testStr = " Hi~ ubuntu에 java 설치";
        System.out.println(testStr);
        return testStr;
    }
}

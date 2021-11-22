package com.example.myboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        String testStr = "시간이 걸리는지 테스트";
        System.out.println(testStr);
        return testStr;
    }
}

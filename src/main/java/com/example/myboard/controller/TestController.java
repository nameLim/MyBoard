package com.example.myboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        String testStr = "yaml, shell 위치 변경";
        System.out.println(testStr);
        return testStr;
    }
}

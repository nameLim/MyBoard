package com.example.myboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("test")
    public String test() {
        String testStr = " Hi~ aws 인스턴스 name 변경 후 app 속성 변경";
        System.out.println(testStr);
        return testStr;
    }
}

package com.example.myboard.controller;

import com.example.myboard.dto.FrontRequestCardDto;
import com.example.myboard.dto.FrontResponseCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {


    @GetMapping("/test")
    public String test() {
        String testStr = "ㄹㄹㄹ";
        System.out.println(testStr);
        return testStr;
    }

}

package com.example.myboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String userId;
    private String title;
    private String content;
}

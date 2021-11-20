package com.example.myboard.dto;

import lombok.Getter;

@Getter
public class CommentDto {
    private Long postId;
    private String comment;
    private boolean isMine = false;
}

package com.example.myboard.model;

import com.example.myboard.dto.PostRequestDto;
import com.example.myboard.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String userId;

    @Column
    private String title;

    @Column
    private String content;

    public Post(PostRequestDto requestDto) {
        this.userId = requestDto.getUserId();
        this.title = requestDto.getTitle();
        this.content = requestDto.getTitle();
    }

    public void update(PostRequestDto requestDto) {
        this.userId = requestDto.getUserId();
        this.title = requestDto.getTitle();
        this.content = requestDto.getTitle();
    }
}

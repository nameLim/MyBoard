package com.example.myboard.model;

import com.example.myboard.dto.CommentDto;
import com.example.myboard.util.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // DB 테이블 역할을 합니다.
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentDto commentDto, User user) {
        this.postId = commentDto.getPostId();
        this.user = user;
        this.comment = commentDto.getComment();
    }
}

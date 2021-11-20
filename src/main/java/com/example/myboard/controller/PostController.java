package com.example.myboard.controller;

import com.example.myboard.dto.PostRequestDto;
import com.example.myboard.model.Post;
import com.example.myboard.repository.PostRepository;
import com.example.myboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPostList() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/posts/{id}")
    public Post getUserPost(@PathVariable Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        return postRepository.save(post);
    }

}

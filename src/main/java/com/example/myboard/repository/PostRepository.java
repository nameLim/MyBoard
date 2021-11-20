package com.example.myboard.repository;

import com.example.myboard.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    //    List<Post> findAllByOrderByModifiedAtDesc(LocalDateTime modifiedAt);
    List<Post> findAllByOrderByModifiedAtDesc();
}

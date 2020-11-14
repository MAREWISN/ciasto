package com.example.karina.services;

import com.example.karina.model.posts.Picture;
import com.example.karina.model.posts.Post;
import com.example.karina.model.posts.PostRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void save(String title, String description, List<Picture> pictures) {
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);
        post.setPostDate(LocalDate.now());
        post.setPictures(pictures);
        postRepository.save(post);
    }
}

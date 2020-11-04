package com.example.karina.controllers;

import com.example.karina.posts.Post;
import com.example.karina.posts.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloController {

    private final PostRepository postRepository;

    public HelloController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }
}

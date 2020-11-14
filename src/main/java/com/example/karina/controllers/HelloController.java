package com.example.karina.controllers;

import com.example.karina.model.posts.Post;
import com.example.karina.services.PostService;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloController {

    private final PostService postService;

    public HelloController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path={"/","index"})
    public String index(Model model) {
        addPosts(model);
        return "index";
    }

    private void addPosts(Model model){
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
    }

}

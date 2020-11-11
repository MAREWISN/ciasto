package com.example.karina.controllers;

import com.example.karina.posts.Post;
import com.example.karina.posts.PostRepository;
import com.example.karina.users.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {
    private final PostRepository postRepository;

    public LoginController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
    }
    @RequestMapping(path={"/login.html","/login"})
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean logged = (Boolean) session.getAttribute("logged");
        if (logged!=null && logged){
            addPosts(model);
            return "index";
        } else
        return "login";
    }

    @RequestMapping("/perform_login")
    public String logout(){
        return "index";
    }

    @RequestMapping(value = "/perform_logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    private void addPosts(Model model){
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
    }
}

package com.example.karina.controllers;

import com.example.karina.services.PictureService;
import com.example.karina.services.PostService;
import com.example.karina.services.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@Controller
public class AdminController {

    private final PictureService pictureService;
    private final PostService postService;
    private final StorageService storageService;

    @Autowired
    public AdminController(PictureService pictureService, PostService postService, StorageService storageService) {
        this.pictureService = pictureService;
        this.postService = postService;
        this.storageService = storageService;
    }

    @GetMapping(path = {"/admin", "/admin.html"})
    public String getAdmin() {
        return "adminPage";
    }

    //TODO POBIERANIE PLIKOW Z INPUTA I ZAPISYWANIE
    // ICH NA DYSKU A POTEM DODANIE ZDJEC I POSTA DO BAZY
    @PostMapping(path = {"/admin", "/admin.html"})
    public String addPost(
            @RequestParam("files") MultipartFile[] files,
            HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse,
                          Model model) throws IOException, ServletException {
        String title = httpServletRequest.getParameter("title");
        String description = httpServletRequest.getParameter("description");
        for (MultipartFile file : files) {
            storageService.store(file);
            System.out.println(file.getName());
        }
        System.out.println(title + " " + description);
        if (title.length() > 0 && description.length() > 0) {
            model.addAttribute("saveError", false);
        } else {
            model.addAttribute("saveError", true);
        }
        return "/adminPage";
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }
}

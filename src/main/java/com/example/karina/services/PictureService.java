package com.example.karina.services;

import com.example.karina.model.posts.Picture;
import com.example.karina.model.posts.PictureRepository;
import org.springframework.stereotype.Service;

@Service
public class PictureService {

    private final PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository){
        this.pictureRepository = pictureRepository;
    }

    public Picture save(Picture picture){
        return pictureRepository.save(picture);
    }
}

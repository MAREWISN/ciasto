package com.example.karina.services;

import com.example.karina.model.posts.Picture;
import com.example.karina.model.posts.PictureRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PictureService {

    private final PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository){
        this.pictureRepository = pictureRepository;
    }

    public Picture save(MultipartFile picture){
        Picture pictureToBeSaved = new Picture();
        pictureToBeSaved.setName(picture.getOriginalFilename());
        String pictureUrl = "/img/" + picture.getOriginalFilename();
        pictureToBeSaved.setUrl(pictureUrl);
        return pictureRepository.save(pictureToBeSaved);
    }
}

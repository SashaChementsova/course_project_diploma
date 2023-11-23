package com.service;

import com.model.ImageEntity;
import com.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageService {
    private final ImageRepository imageRepository;
    @Autowired
    public ImageService(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    public ImageEntity addAndUpdateImage(ImageEntity imageEntity){
        return imageRepository.save(imageEntity);
    }
    public List<ImageEntity> getImages(){
        return imageRepository.findAll();
    }

    public ImageEntity findImageById(int id){

        return imageRepository.findById(id).orElse(null);
    }
    public void deleteImage(int id){
        imageRepository.deleteById(id);
    }
}

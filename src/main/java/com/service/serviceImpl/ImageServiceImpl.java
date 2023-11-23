package com.service.serviceImpl;

import com.model.Image;
import com.repository.ImageRepository;
import com.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }
    @Override
    public Image addAndUpdateImage(Image image){
        return imageRepository.save(image);
    }
    @Override
    public List<Image> getImages(){
        return imageRepository.findAll();
    }
    @Override
    public Image findImageById(int id){

        return imageRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteImage(int id){
        imageRepository.deleteById(id);
    }
}

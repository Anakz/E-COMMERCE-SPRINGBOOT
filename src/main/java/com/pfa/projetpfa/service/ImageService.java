package com.pfa.projetpfa.service;

import com.pfa.projetpfa.dao.ImageRepository;
import com.pfa.projetpfa.domaine.ImageConverter;
import com.pfa.projetpfa.domaine.ImageVo;
import com.pfa.projetpfa.service.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<ImageVo> getImages() {
        List<Image> list = imageRepository.findAll();
        return ImageConverter.toListVo(list);
    }

    @Override
    public void save(ImageVo image) {
        imageRepository.save(ImageConverter.toBo(image));
    }

    @Override
    public ImageVo getImageById(Long id) {
        boolean foundImage = imageRepository.existsById(id);
        if (!foundImage)
            return null;
        return ImageConverter.toVo(imageRepository.getOne(id));
    }
    public ImageVo getImageByProduct(Long id) {
        boolean foundImage = imageRepository.existsById(id);
        if (!foundImage)
            return null;
        return ImageConverter.toVo(imageRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {
        imageRepository.deleteById(id);
    }

}

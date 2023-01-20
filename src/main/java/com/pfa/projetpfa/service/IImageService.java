package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.ImageVo;
import com.pfa.projetpfa.service.model.Image;

import java.util.List;

public interface IImageService {
    List<ImageVo> getImages();

    void save(ImageVo image);

    ImageVo getImageById(Long id);

    void delete(Long id);
}

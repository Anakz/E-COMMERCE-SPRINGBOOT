package com.pfa.projetpfa.controller;

import com.pfa.projetpfa.domaine.ImageVo;
import com.pfa.projetpfa.domaine.ProductConverter;
import com.pfa.projetpfa.domaine.ProductVo;
import com.pfa.projetpfa.service.IImageService;
import com.pfa.projetpfa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ImageController {
    @Autowired
    private IImageService service;
    @Autowired
    private IProductService serviceProduct;

    @GetMapping(value = "/api/image", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ImageVo> getAll(){
        return service.getImages();
    }
    @GetMapping(value = "/api/image/{id}")
    public ResponseEntity<Object> getImageById(@PathVariable(value = "id") Long imageVoId){
        ImageVo imageVoFound = service.getImageById(imageVoId);
        if (imageVoFound == null)
            return new ResponseEntity<>("image doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(imageVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/api/image")
    public ResponseEntity<Object> createImage(@Validated @RequestBody ImageVo imageVo){
        ProductVo productVo = serviceProduct.getProductById(imageVo.getProduct().getId());
        imageVo.setProduct(ProductConverter.toBo(productVo));
        service.save(imageVo);
        return new ResponseEntity<>("Image created with success", HttpStatus.CREATED);
    }
    @PutMapping(value = "/api/image/{id}")
    public ResponseEntity<Object> updateImage(@PathVariable(name = "id") Long imageVoId, @RequestBody ImageVo imageVo){
        ImageVo imageVoFound = service.getImageById(imageVoId);
        if (imageVoFound == null)
            return new ResponseEntity<>("Image doesn't exist", HttpStatus.OK);
        imageVo.setId(imageVoId);
        service.save(imageVo);
        return new ResponseEntity<>("Image is updated successfully", HttpStatus.OK);
    }
}

package com.pfa.projetpfa.controller;

import com.pfa.projetpfa.domaine.ImageVo;
import com.pfa.projetpfa.domaine.ProductVo;
import com.pfa.projetpfa.service.IImageService;
import com.pfa.projetpfa.service.IProductService;
import com.pfa.projetpfa.service.model.Image;
import com.pfa.projetpfa.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
public class ProductController {

    @Autowired
    private IProductService service;

    @Autowired
    private IImageService imageService;

    @GetMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductVo> getAll(){
        return service.getProducts();
    }

    @GetMapping(value = "/api/product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable(value = "id") Long productVoId){
        ProductVo productVoFound = service.getProductById(productVoId);
        if (productVoFound == null)
            return new ResponseEntity<>("product doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(productVoFound, HttpStatus.OK);
    }

    @PostMapping(value = "/api/product")
    public ResponseEntity<Object> createProduct(@Validated @RequestBody ProductVo productVo) {
        ProductVo createdProduct =  service.save(productVo);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(name = "id") Long productVoId, @RequestBody ProductVo productVo) {
        ProductVo productVoFound = service.getProductById(productVoId);
        if (productVoFound == null)
            return new ResponseEntity<>("Product doesn't exist", HttpStatus.OK);
        productVo.setId(productVoId);
        productVo.setCategory(productVoFound.getCategory());
        productVo.setImages(productVoFound.getImages());
        service.save(productVo);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/api/product/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(name = "id") Long productVoId, @RequestBody ProductVo productVo) {
        ProductVo productVoFound = service.getProductById(productVoId);
        if (productVoFound == null)
            return new ResponseEntity<>("Product doesn't exist", HttpStatus.OK);
        productVoFound.setIs_deleted(true);
        service.save(productVoFound);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }



    /*@DeleteMapping(value = "/api/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(name = "id") Long productVoId) {
        ProductVo productVoFound = service.getProductById(productVoId);
        if (productVoFound == null)
            return new ResponseEntity<>("Le produit n'existe pas", HttpStatus.OK);
        //productVoFound.setCategory(null);
        service.delete(productVoId);
        return new ResponseEntity<>("Product deleted with success", HttpStatus.OK);
    }*/
}

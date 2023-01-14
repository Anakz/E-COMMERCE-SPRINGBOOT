package com.pfa.projetpfa.controller;

import com.pfa.projetpfa.domaine.ProductVo;
import com.pfa.projetpfa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {

    @Autowired
    private IProductService service;

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
}

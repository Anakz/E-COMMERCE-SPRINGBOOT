package com.pfa.projetpfa.controller;


import com.pfa.projetpfa.domaine.BasketVo;
import com.pfa.projetpfa.domaine.UserVo;
import com.pfa.projetpfa.service.BasketService;
import com.pfa.projetpfa.service.IBasketService;
import com.pfa.projetpfa.service.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= {"*"})
@RestController
public class BasketController {
    @Autowired
    private IBasketService service;

    @GetMapping("/api/basket")
    public List<BasketVo> getBaskets(){
        return service.getBaskets();
    }
    @GetMapping(value = "/api/basket/{id}")
    public ResponseEntity<Object> getBasketById(@PathVariable(value = "id") Long basketVoId) {
        BasketVo basketVoFound = service.getBasketById(basketVoId);
        if (basketVoFound == null)
            return new ResponseEntity<>("Basket doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(basketVoFound, HttpStatus.OK);
    }
    @GetMapping(value = "/api/basket/user/{user}")
    public ResponseEntity<Object> getBasketByUser(@PathVariable(value = "user") User user) {
        BasketVo basketVoFound = service.getBasketByUser(user);
        if (basketVoFound == null)
            return new ResponseEntity<>("Basket doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(basketVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/api/basket", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createBasket(@RequestBody BasketVo basketVo){
        service.save(basketVo);
        BasketVo savedBasket = service.findLastCreated();
        return new ResponseEntity<>(savedBasket, HttpStatus.CREATED);
    }
    @PutMapping(value = "/api/basket/{id}")
    public ResponseEntity<Object> updateBasket(@PathVariable(name = "id") Long basketVoId, @RequestBody BasketVo basketVo){
        BasketVo basketVoFound = service.getBasketById(basketVoId);
        if (basketVoFound == null)
            return new ResponseEntity<>("basket doesn't exist", HttpStatus.OK);
        basketVo.setId(basketVoId);
        service.save(basketVo);
        return new ResponseEntity<>("Basket is updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/api/basket/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long basketVoId) {
        BasketVo basketVoFound = service.getBasketById(basketVoId);
        if (basketVoFound == null)
            return new ResponseEntity<>("basket doesn't exist", HttpStatus.OK);
        service.delete(basketVoId);
        return new ResponseEntity<>("Basket is updated successfully", HttpStatus.OK);
    }
}
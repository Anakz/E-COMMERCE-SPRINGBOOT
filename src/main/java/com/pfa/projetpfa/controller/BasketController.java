package com.pfa.projetpfa.controller;


import com.pfa.projetpfa.domaine.*;
import com.pfa.projetpfa.service.BasketService;
import com.pfa.projetpfa.service.IBasketService;
import com.pfa.projetpfa.service.IProductService;
import com.pfa.projetpfa.service.IUserService;
import com.pfa.projetpfa.service.model.Basket;
import com.pfa.projetpfa.service.model.Product;
import com.pfa.projetpfa.service.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins= {"*"})
@RestController
public class BasketController {
    @Autowired
    private IBasketService service;
    @Autowired
    private IProductService serviceProduct;

    @Autowired
    private IUserService serviceUser;

    @GetMapping(value ="/api/basket", produces = MediaType.APPLICATION_JSON_VALUE)
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

        Long user_id = basketVo.getUser().getId();
        UserVo userVo = serviceUser.getUserById(user_id);
        userVo.setBasket(BasketConverter.toBo(savedBasket));
        serviceUser.save(userVo);

        return new ResponseEntity<>(savedBasket, HttpStatus.CREATED);
    }
    @PutMapping(value = "/api/basket/{id}")
    public ResponseEntity<Object> updateBasket(@PathVariable(name = "id") Long basketVoId, @RequestBody Long productVoId){
        BasketVo basketVoFound = service.getBasketById(basketVoId);
        if (basketVoFound == null)
            return new ResponseEntity<>("basket doesn't exist", HttpStatus.OK);
        ProductVo product_to_add = serviceProduct.getProductById(productVoId);
        List<Product> list = new ArrayList<>(basketVoFound.getProduct());
        list.add(ProductConverter.toBo(product_to_add));

        for (Product product : list) {
            if (product.getId().equals(product_to_add.getId())) {
                product.setSelected_quantity(22);
                System.out.println("------------------------------");
            }
        }
        basketVoFound.setProduct(list);
        service.save(basketVoFound);
        return new ResponseEntity<>("Basket is updated successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/api/basket/product/{id}")
    public ResponseEntity<Object> updateBasket2(@PathVariable(name = "id") Long basketVoId, @RequestBody ProductVo productVo){
        BasketVo basketVoFound = service.getBasketById(basketVoId);
        if (basketVoFound == null)
            return new ResponseEntity<>("basket doesn't exist", HttpStatus.OK);
        ProductVo productFound = serviceProduct.getProductById(productVo.getId());
        if (productFound == null)
            return new ResponseEntity<>("basket doesn't exist", HttpStatus.OK);
        List<Product> list = new ArrayList<>(basketVoFound.getProduct());
        boolean b = false;
        Product product = new Product();
        if (list.size()>0){
            for (Product product_ : list) {
                if (product_.getId().equals(productFound.getId())) {
                    product = product_;
                    b = true;
                }
            }
            if (b)
            {
                list.remove(product);
                product.setSelected_quantity(product.getSelected_quantity()+1);
                list.add(product);
                basketVoFound.setProduct(list);
                service.save(basketVoFound);
            }
        }
        return new ResponseEntity<>("Basket is updated successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/api/basket/deleteproduct/{id}")
    public ResponseEntity<Object> updateBasket3(@PathVariable(name = "id") Long basketVoId, @RequestBody Long productVoId){
        BasketVo basketVoFound = service.getBasketById(basketVoId);
        if (basketVoFound == null)
            return new ResponseEntity<>("basket doesn't exist", HttpStatus.OK);
        ProductVo productFound = serviceProduct.getProductById(productVoId);
        if (productFound == null)
            return new ResponseEntity<>("basket doesn't exist", HttpStatus.OK);
        List<Product> list = new ArrayList<>(basketVoFound.getProduct());
        boolean b = false;
        Product product = new Product();
        if (list.size()>0){
            for (Product product_ : list) {
                if (product_.getId().equals(productFound.getId())) {
                    product = product_;
                    b=true;
                }
            }
            if (b)
            {
                list.remove(product);
                if (product.getSelected_quantity() > 1)
                {
                    product.setSelected_quantity(product.getSelected_quantity()-1);
                    list.add(product);
                }
                basketVoFound.setProduct(list);
                service.save(basketVoFound);
            }
        }
        return new ResponseEntity<>("Basket is updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/api/basket/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long basketVoId) {
        BasketVo basketVoFound = service.getBasketById(basketVoId);
        if (basketVoFound == null)
            return new ResponseEntity<>("basket doesn't exist", HttpStatus.OK);
        List<Product> list = basketVoFound.getProduct();
        list.removeAll(list);
        service.save(basketVoFound);
        //service.delete(basketVoId);
        return new ResponseEntity<>("Basket is updated successfully", HttpStatus.OK);
    }
}
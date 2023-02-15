package com.pfa.projetpfa.controller;

import com.pfa.projetpfa.domaine.OrderVo;
import com.pfa.projetpfa.domaine.ProductVo;
import com.pfa.projetpfa.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
public class OrderController {

    @Autowired
    private IOrderService service;

    @GetMapping(value = "/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderVo> getAll(){
        return service.getOrders();
    }
    @GetMapping(value = "/api/order/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable(value = "id") Long orderVoId){
        OrderVo orderVoFound = service.getOrderById(orderVoId);
        if (orderVoFound == null)
            return new ResponseEntity<>("product doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(orderVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/api/order")
    public ResponseEntity<Object> createOrder(@Validated @RequestBody OrderVo orderVo) {
        OrderVo createdOrder =  service.save(orderVo);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
    @PutMapping(value = "/api/order/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable(name = "id") Long orderVoId, @RequestBody OrderVo orderVo) {
        OrderVo orderVoFound = service.getOrderById(orderVoId);
        if (orderVoFound == null)
            return new ResponseEntity<>("Product doesn't exist", HttpStatus.OK);
        orderVo.setId(orderVoId);
        service.save(orderVo);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/api/order/delete/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable(name = "id") Long orderVoId, @RequestBody OrderVo orderVo) {
        OrderVo orderVoFound = service.getOrderById(orderVoId);
        if (orderVoFound == null)
            return new ResponseEntity<>("Product doesn't exist", HttpStatus.OK);
        orderVoFound.setIs_deleted(true);
        service.save(orderVoFound);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

}

package com.pfa.projetpfa.controller;

import com.pfa.projetpfa.domaine.DeliveryVo;
import com.pfa.projetpfa.domaine.OrderVo;
import com.pfa.projetpfa.service.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
public class DeliveryController {

    @Autowired
    private IDeliveryService service;

    @GetMapping(value = "/api/delivery", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeliveryVo> getAll(){
        return service.getDeliveries();
    }
    @GetMapping(value = "/api/delivery/{id}")
    public ResponseEntity<Object> getDeliveryById(@PathVariable(value = "id") Long deliveryVoId){
        DeliveryVo deliveryVoFound = service.getDeliveryById(deliveryVoId);
        if (deliveryVoFound == null)
            return new ResponseEntity<>("Delivery doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(deliveryVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/api/delivery")
    public ResponseEntity<Object> createDelivery(@Validated @RequestBody DeliveryVo deliveryVo) {
        DeliveryVo createdDelivery =  service.save(deliveryVo);
        return new ResponseEntity<>(createdDelivery, HttpStatus.CREATED);
    }
    @PutMapping(value = "/api/delivery/{id}")
    public ResponseEntity<Object> updateDelivery(@PathVariable(name = "id") Long deliveryVoId, @RequestBody DeliveryVo deliveryVo) {
        DeliveryVo deliveryVoFound = service.getDeliveryById(deliveryVoId);
        if (deliveryVoFound == null)
            return new ResponseEntity<>("Delivery doesn't exist", HttpStatus.OK);
        deliveryVo.setId(deliveryVoId);
        service.save(deliveryVo);
        return new ResponseEntity<>("Delivery updated successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/api/delivery/delete/{id}")
    public ResponseEntity<Object> deleteDelivery(@PathVariable(name = "id") Long deliveryVoId, @RequestBody DeliveryVo deliveryVo) {
        DeliveryVo deliveryVoFound = service.getDeliveryById(deliveryVoId);
        if (deliveryVoFound == null)
            return new ResponseEntity<>("Delivery doesn't exist", HttpStatus.OK);
        deliveryVoFound.setIs_deleted(true);
        service.save(deliveryVoFound);
        return new ResponseEntity<>("Delivery is deleted successfully", HttpStatus.OK);
    }
}

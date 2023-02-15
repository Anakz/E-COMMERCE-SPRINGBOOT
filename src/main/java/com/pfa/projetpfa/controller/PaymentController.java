package com.pfa.projetpfa.controller;

import com.pfa.projetpfa.domaine.PaymentVo;
import com.pfa.projetpfa.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
public class PaymentController {
    @Autowired
    private IPaymentService service;

    @GetMapping(value = "/api/payment", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentVo> getAll(){
        return service.getPayments();
    }
    @GetMapping(value = "/api/payment/{id}")
    public ResponseEntity<Object> getPaymentById(@PathVariable(value = "id") Long paymentVoId){
        PaymentVo paymentVoFound = service.getPaymentById(paymentVoId);
        if (paymentVoFound == null)
            return new ResponseEntity<>("Payment doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(paymentVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/api/payment")
    public ResponseEntity<Object> createPayment(@Validated @RequestBody PaymentVo paymentVo) {
        PaymentVo createdPayment =  service.save(paymentVo);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }
    @PutMapping(value = "/api/payment/{id}")
    public ResponseEntity<Object> updatePayment(@PathVariable(name = "id") Long paymentVoId, @RequestBody PaymentVo paymentVo) {
        PaymentVo paymentVoFound = service.getPaymentById(paymentVoId);
        if (paymentVoFound == null)
            return new ResponseEntity<>("Payment doesn't exist", HttpStatus.OK);
        paymentVo.setId(paymentVoId);
        service.save(paymentVo);
        return new ResponseEntity<>("Payment updated successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/api/payment/delete/{id}")
    public ResponseEntity<Object> deletePayment(@PathVariable(name = "id") Long paymentVoId, @RequestBody PaymentVo paymentVo) {
        PaymentVo paymentVoFound = service.getPaymentById(paymentVoId);
        if (paymentVoFound == null)
            return new ResponseEntity<>("Payment doesn't exist", HttpStatus.OK);
        paymentVoFound.setIs_deleted(true);
        service.save(paymentVoFound);
        return new ResponseEntity<>("Payment is deleted successfully", HttpStatus.OK);
    }
}

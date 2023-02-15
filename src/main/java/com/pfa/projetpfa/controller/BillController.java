package com.pfa.projetpfa.controller;

import com.pfa.projetpfa.domaine.BillVo;
import com.pfa.projetpfa.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
public class BillController {
    @Autowired
    private IBillService service;
    @GetMapping(value = "/api/bill", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BillVo> getAll(){
        return service.getBills();
    }
    @GetMapping(value = "/api/bill/{id}")
    public ResponseEntity<Object> getBillById(@PathVariable(value = "id") Long billVoId){
        BillVo billVoFound = service.getBillById(billVoId);
        if (billVoFound == null)
            return new ResponseEntity<>("product doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(billVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/api/bill")
    public ResponseEntity<Object> createBill(@Validated @RequestBody BillVo billVo) {
        BillVo createdBill =  service.save(billVo);
        return new ResponseEntity<>(createdBill, HttpStatus.CREATED);
    }
    @PutMapping(value = "/api/bill/{id}")
    public ResponseEntity<Object> updateBill(@PathVariable(name = "id") Long billVoId, @RequestBody BillVo billVo) {
        BillVo billVoFound = service.getBillById(billVoId);
        if (billVoFound == null)
            return new ResponseEntity<>("Bill doesn't exist", HttpStatus.OK);
        billVo.setId(billVoId);
        service.save(billVo);
        return new ResponseEntity<>("Bill updated successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/api/bill/delete/{id}")
    public ResponseEntity<Object> deleteBill(@PathVariable(name = "id") Long billVoId, @RequestBody BillVo billVo) {
        BillVo billVoFound = service.getBillById(billVoId);
        if (billVoFound == null)
            return new ResponseEntity<>("Bill doesn't exist", HttpStatus.OK);
        billVoFound.setIs_deleted(true);
        service.save(billVoFound);
        return new ResponseEntity<>("Bill is deleted successfully", HttpStatus.OK);
    }
}

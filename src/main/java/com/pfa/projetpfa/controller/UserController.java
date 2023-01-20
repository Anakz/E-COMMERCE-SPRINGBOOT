package com.pfa.projetpfa.controller;

import com.pfa.projetpfa.domaine.UserVo;
import com.pfa.projetpfa.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserVo> getAll() {
        return service.getUsers();
    }
    // Search a user from his ID
    @GetMapping(value = "/api/user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable(value = "id") Long userVoId) {
        UserVo userVoFound = service.getUserById(userVoId);
        if (userVoFound == null)
            return new ResponseEntity<>("user doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(userVoFound, HttpStatus.OK);
    }
    @PostMapping(value = "/api/user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserVo userVo){
        service.save(userVo);
        return new ResponseEntity<>("user is created successfully", HttpStatus.CREATED);
    }

    // To modify a user by his ID
    @PutMapping(value = "/api/user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(name = "id") Long userVoId, @RequestBody UserVo userVo){
        UserVo userVoFound = service.getUserById(userVoId);
        if (userVoFound == null)
            return new ResponseEntity<>("user doen't exist", HttpStatus.OK);
        userVo.setId(userVoId);
        service.save(userVo);
        return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
    }
    // Search all users
}

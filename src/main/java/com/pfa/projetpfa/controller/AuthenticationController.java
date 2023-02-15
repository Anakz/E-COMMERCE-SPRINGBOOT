package com.pfa.projetpfa.controller;

import com.pfa.projetpfa.domaine.TokenVo;
import com.pfa.projetpfa.domaine.UserVo;
import com.pfa.projetpfa.jwt.JwtUtils;
import com.pfa.projetpfa.service.IUserService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthenticationController {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping(value = "/api/signin")
    public ResponseEntity<TokenVo> authenticateUser(@Valid @RequestBody UserVo userVo){
        try {

            String email = userVo.getEmail();
            String password = userVo.getPassword();

            boolean userVoExist = userService.existsByEmailAndPassword(email, password);
            if (!userVoExist)
                throw new RuntimeException("Login or password incorrect 0");

            UserVo userVoFound = userService.findByEmailAndPassword(email, password);

            String jwt = jwtUtils.generateJwtToken(userVoFound.getEmail());

            TokenVo tokenVo = new TokenVo();
            tokenVo.setJwttoken(jwt);
            tokenVo.setUsername(userVoFound.getEmail());
            tokenVo.setRoles(userVoFound.getRole());

            return ResponseEntity.ok(tokenVo);
        } catch (Exception e) {
            throw new RuntimeException("Login or password incorrect");
        }
    }
    @PostMapping(value = "/api/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserVo userVo){
        if (userService.existsByEmail(userVo.getEmail())){
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        userVo.setRole("CLIENT");
        userService.save(userVo);
        return ResponseEntity.ok("User registered successfully!");
    }
}

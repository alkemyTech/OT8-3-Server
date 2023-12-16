package com.alkemy.wallet.controller;

import com.alkemy.wallet.dto.LoginUserRequestDTO;
import com.alkemy.wallet.dto.JwtResponseDTO;
import com.alkemy.wallet.dto.RegisterUserRequestDTO;
import com.alkemy.wallet.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponseDTO> registerUser(@RequestBody RegisterUserRequestDTO register){
        return new ResponseEntity<>(authService.registerUser(register) , HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> loginUser(@RequestBody LoginUserRequestDTO login){
        return new ResponseEntity<>(authService.loginUser(login),HttpStatus.OK);
    }
}

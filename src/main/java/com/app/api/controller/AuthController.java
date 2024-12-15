package com.app.api.controller;

import com.app.api.dto.AuthRequest;
import com.app.api.dto.AuthResponse;
import com.app.api.dto.RegisterRequest;
import com.app.api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid AuthRequest request){
        return authService.login(request);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequest request){
        authService.register(request);
    }
}

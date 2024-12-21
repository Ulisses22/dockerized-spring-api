package com.app.api.controller;

import com.app.api.dto.AuthRequest;
import com.app.api.dto.AuthResponse;
import com.app.api.dto.RegisterRequest;
import com.app.api.entity.User;
import com.app.api.repository.UserRepository;
import com.app.api.service.AuthService;
import com.app.api.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthController(AuthService authService, JwtUtil jwtUtil, UserRepository userRepository){
        this.authService = authService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid AuthRequest request){
        return authService.login(request);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequest request){
        authService.register(request);
    }

    @GetMapping("/activate")
    public ResponseEntity<String> activateAccount(@RequestParam("token") String token) {
        boolean isActivated = authService.activateAccount(token);

        if (isActivated) {
            return ResponseEntity.ok("Account activated successfully!");
        } else {
            return ResponseEntity.badRequest().body("Account is already activated!");
        }
    }
}

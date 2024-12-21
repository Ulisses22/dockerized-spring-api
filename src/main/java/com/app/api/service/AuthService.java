package com.app.api.service;

import com.app.api.dto.AuthRequest;
import com.app.api.dto.AuthResponse;
import com.app.api.dto.RegisterRequest;
import com.app.api.entity.User;
import com.app.api.repository.UserRepository;
import com.app.api.util.JwtUtil;
import jdk.jfr.Registered;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final EmailService emailService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.emailService = emailService;
    }

    public AuthResponse login(AuthRequest request) {
        Optional<User> user = userRepository.findByUsername(request.getUsername());

        if (user.isPresent()) {
            User foundUser = user.get();

            // Verificar se a conta está ativa
            if (!foundUser.getIsActive()) {
                throw new RuntimeException("Account is not activated");
            }

            // Verificar se a senha está correta
            if (passwordEncoder.matches(request.getPassword(), foundUser.getPassword())) {
                String token = jwtUtil.generateToken(request.getUsername());
                return new AuthResponse(token);
            }
        }
        throw new RuntimeException("Invalid credentials");
    }

        public void register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setIsActive(false);

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getUsername());
        emailService.sendActivationEmail(request.getEmail(), token);
    }

    public boolean activateAccount(String token) {
        String username = jwtUtil.extractUsername(token);

        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Invalid token or user not found");
        }

        User user = userOptional.get();

        if (!user.getIsActive()) {
            user.setIsActive(true);
            userRepository.save(user);
            return true;  // Account activated successfully
        }

        return false;  // Account already activated
    }
}
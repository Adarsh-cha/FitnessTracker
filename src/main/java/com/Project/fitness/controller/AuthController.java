package com.Project.fitness.controller;

import com.Project.fitness.dto.LoginRequest;
import com.Project.fitness.dto.LoginResponse;
import com.Project.fitness.dto.RegisterRequest;
import com.Project.fitness.dto.UserResponse;
import com.Project.fitness.model.User;
import com.Project.fitness.repository.UserRepository;
import com.Project.fitness.security.JwtUtils;
import com.Project.fitness.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try{
            User user = userService.login(loginRequest);

            String token = jwtUtils.generateToken(user.getId(), user.getRole().name());
            return ResponseEntity.ok(new LoginResponse(token, userService.mappedUserResponse(user)));
        } catch (AuthenticationException e) {
            e.getSuppressed();
            return ResponseEntity.status(401).build();
        }
    }
}

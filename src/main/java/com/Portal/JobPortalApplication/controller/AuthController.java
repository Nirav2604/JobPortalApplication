package com.Portal.JobPortalApplication.controller;

import com.Portal.JobPortalApplication.dto.AuthResponse;
import com.Portal.JobPortalApplication.dto.LoginRequest;
import com.Portal.JobPortalApplication.dto.RegisterRequest;
import com.Portal.JobPortalApplication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest){
        authService.register(registerRequest);
        return "Registered Successfully!!!";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        authService.login(request);
        return "Login Successfully!!!";
    }
}

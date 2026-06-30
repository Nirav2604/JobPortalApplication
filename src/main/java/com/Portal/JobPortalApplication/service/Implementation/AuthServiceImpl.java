package com.Portal.JobPortalApplication.service.Implementation;

import com.Portal.JobPortalApplication.dto.AuthResponse;
import com.Portal.JobPortalApplication.dto.LoginRequest;
import com.Portal.JobPortalApplication.dto.RegisterRequest;
import com.Portal.JobPortalApplication.entity.User;
import com.Portal.JobPortalApplication.repository.UserRepository;
import com.Portal.JobPortalApplication.service.AuthService;
import com.Portal.JobPortalApplication.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Override
    public String register(RegisterRequest registerRequest) {

        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            throw new RuntimeException("Email not exist");
        }
        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .is_active(true)
                .build();

        userRepository.save(user);
        return "User Registered Successfully!!!!!";
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        User user=userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()->new RuntimeException("User Not Found"));

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid Credentials");
        }

        String token= jwtService.generateToken(user);
        return new AuthResponse(token, "Login successful");
    }
}

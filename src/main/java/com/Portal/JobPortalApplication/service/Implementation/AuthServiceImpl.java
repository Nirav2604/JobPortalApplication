package com.Portal.JobPortalApplication.service.Implementation;

import com.Portal.JobPortalApplication.dto.RegisterRequest;
import com.Portal.JobPortalApplication.entity.User;
import com.Portal.JobPortalApplication.repository.UserRepository;
import com.Portal.JobPortalApplication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequest registerRequest) {

        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            throw new RuntimeException("Email not exist");
        }
        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getName())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .is_active(true)
                .build();

        userRepository.save(user);
        return "User Registered Successfully!!!!!";
    }
}

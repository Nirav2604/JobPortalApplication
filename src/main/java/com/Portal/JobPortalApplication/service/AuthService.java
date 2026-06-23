package com.Portal.JobPortalApplication.service;

import com.Portal.JobPortalApplication.dto.AuthResponse;
import com.Portal.JobPortalApplication.dto.LoginRequest;
import com.Portal.JobPortalApplication.dto.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
}

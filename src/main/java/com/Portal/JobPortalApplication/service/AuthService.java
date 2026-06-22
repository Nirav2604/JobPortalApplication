package com.Portal.JobPortalApplication.service;

import com.Portal.JobPortalApplication.dto.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest registerRequest);
}

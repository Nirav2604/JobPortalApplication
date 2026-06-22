package com.Portal.JobPortalApplication.dto;

import com.Portal.JobPortalApplication.Entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}

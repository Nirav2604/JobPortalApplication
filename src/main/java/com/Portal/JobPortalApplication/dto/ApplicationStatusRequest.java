package com.Portal.JobPortalApplication.dto;

import com.Portal.JobPortalApplication.entity.ApplicationStatus;
import lombok.Data;

@Data
public class ApplicationStatusRequest {
    private ApplicationStatus applicationStatus;
}

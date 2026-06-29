package com.Portal.JobPortalApplication.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobRequest {
    private String title;
    private String description;
    private String location;
    private Double salary;
    private Integer experienceRequired;
    private String jobType;
}

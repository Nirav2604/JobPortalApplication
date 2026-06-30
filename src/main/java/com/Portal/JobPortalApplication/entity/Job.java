package com.Portal.JobPortalApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 3000)
    private String description;

    private String location;

    private Double salary;

    private Integer experienceRequired;

    private String jobType;

    private LocalDateTime postedDate;

    @Column(length = 1000)
    private String skills;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}

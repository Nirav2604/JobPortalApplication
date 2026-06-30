package com.Portal.JobPortalApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String skills;

    private String experience;

    private String education;

    private String resumeUrl;

    private Boolean active;

    @OneToOne
    @JoinColumn(name ="User_id",unique = true)
    private User user;
}

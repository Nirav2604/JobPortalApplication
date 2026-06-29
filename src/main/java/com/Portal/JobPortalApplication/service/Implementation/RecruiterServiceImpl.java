package com.Portal.JobPortalApplication.service.Implementation;

import com.Portal.JobPortalApplication.dto.CompanyRequest;
import com.Portal.JobPortalApplication.entity.Company;
import com.Portal.JobPortalApplication.entity.User;
import com.Portal.JobPortalApplication.repository.CompanyRepository;
import com.Portal.JobPortalApplication.repository.UserRepository;
import com.Portal.JobPortalApplication.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class RecruiterServiceImpl implements RecruiterService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @Override
    public Company createCompany(String email, CompanyRequest companyRequest) {
        User recruiter= userRepository.findByEmail(email).orElseThrow();

        if(companyRepository.findByRecruiter(recruiter).isPresent()){
            throw new RuntimeException("Company Already Exists!!!!!(while creating)");
        }
        Company company=Company.builder()
                .companyName(companyRequest.getCompanyName())
                .website(companyRequest.getWebsite())
                .description(companyRequest.getDescription())
                .location(companyRequest.getLocation())
                .recruiter(recruiter)
                .build();
        return companyRepository.save(company);
    }

    @Override
    public Company getCompany(String email) {

        User recruiter=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Recruiter Doesn't Exists(while fetching)!!!!"));

        return companyRepository.findByRecruiter(recruiter).orElseThrow(()->
                new RuntimeException("Company Doesn't Exists!!!!"));
    }

    @Override
    public Company updateCompany(String email, CompanyRequest companyRequest) {
        User recruiter= userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Recruiter Doesn't Exists(while updating)!!!!"));
        Company company=companyRepository.findByRecruiter(recruiter).orElseThrow(()->new RuntimeException("Company Doesn't Exists(while updating)!!!!"));

            company.setCompanyName(companyRequest.getCompanyName());
            company.setWebsite(companyRequest.getWebsite());
            company.setDescription(companyRequest.getDescription());
            company.setLocation(companyRequest.getLocation());
        return companyRepository.save(company);
    }
}

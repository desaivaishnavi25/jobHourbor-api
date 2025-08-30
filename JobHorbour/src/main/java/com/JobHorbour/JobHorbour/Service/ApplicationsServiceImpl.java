package com.JobHorbour.JobHorbour.Service;


import com.JobHorbour.JobHorbour.Dto.CreateApplicationsDto;
import com.JobHorbour.JobHorbour.Entity.Applications;
import com.JobHorbour.JobHorbour.Entity.Company;
import com.JobHorbour.JobHorbour.Entity.User;
import com.JobHorbour.JobHorbour.Repository.ApplicationsRepository;
import com.JobHorbour.JobHorbour.Repository.CompanyRepository;
import com.JobHorbour.JobHorbour.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApplicationsServiceImpl extends ApplicationsService {

    @Autowired
    ApplicationsRepository applicationsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void apply(CreateApplicationsDto dto) throws Exception {
        Long userId = dto.getUser();
        Long companyId = dto.getCompany();
        Optional<User> user = userRepository.findById(userId);
        Optional<Company> company = companyRepository.findById(companyId);
        Optional<Applications> existingApplication = applicationsRepository.findByUserIdAndCompanyId(userId,companyId);
        if(!existingApplication.isEmpty()){
            throw new Exception("Application already exists");
        }
        Applications applicationEntity = new Applications();
        applicationEntity.setUser(user.get());
        applicationEntity.setCompany(company.get());
        applicationsRepository.save(applicationEntity);
    }
}

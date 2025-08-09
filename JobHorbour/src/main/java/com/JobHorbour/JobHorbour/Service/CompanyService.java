package com.JobHorbour.JobHorbour.Service;

import com.JobHorbour.JobHorbour.Dto.CreateCompanyDto;
import com.JobHorbour.JobHorbour.Dto.CreateProfileDto;
import com.JobHorbour.JobHorbour.Dto.UpdateCompanyDto;
import com.JobHorbour.JobHorbour.Dto.UpdateProfileDto;
import com.JobHorbour.JobHorbour.Entity.Company;
import com.JobHorbour.JobHorbour.Entity.Profile;
import org.springframework.stereotype.Service;

@Service
public abstract class CompanyService {
    public abstract void createCompany(Long userId, CreateCompanyDto createCompanyDto) throws Exception;
    public abstract void updateCompany(Long userId, UpdateCompanyDto updateCompanyDto) throws Exception;
    public abstract void deleteProfile(Long userId) throws Exception;
    public abstract Company getCompanyByUserId(Long userId) throws Exception;
}

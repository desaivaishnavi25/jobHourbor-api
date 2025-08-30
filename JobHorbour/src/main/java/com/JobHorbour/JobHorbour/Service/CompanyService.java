package com.JobHorbour.JobHorbour.Service;

import com.JobHorbour.JobHorbour.Dto.CreateCompanyDto;
import com.JobHorbour.JobHorbour.Dto.CreateProfileDto;
import com.JobHorbour.JobHorbour.Dto.UpdateCompanyDto;
import com.JobHorbour.JobHorbour.Dto.UpdateProfileDto;
import com.JobHorbour.JobHorbour.Entity.Company;
import com.JobHorbour.JobHorbour.Entity.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CompanyService {
    public abstract void createCompany(Long userId, CreateCompanyDto createCompanyDto) throws Exception;
    public abstract void updateCompany(Long companyId, UpdateCompanyDto updateCompanyDto) throws Exception;
    public abstract void deleteProfile(Long companyId) throws Exception;
    public abstract List<Company> getCompanyByUserId(Long userId) throws Exception;
    public abstract Company getCompanyById(Long companyId) throws Exception;
    public abstract List<Company> getAllCompanies() throws Exception;
    public abstract List<Company> getAppliedCompaniesByUserId(Long UserId);
}

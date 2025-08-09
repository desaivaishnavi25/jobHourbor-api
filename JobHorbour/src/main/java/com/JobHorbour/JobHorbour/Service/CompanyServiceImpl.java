package com.JobHorbour.JobHorbour.Service;


import com.JobHorbour.JobHorbour.Dto.CreateCompanyDto;
import com.JobHorbour.JobHorbour.Dto.CreateProfileDto;
import com.JobHorbour.JobHorbour.Dto.UpdateCompanyDto;
import com.JobHorbour.JobHorbour.Dto.UpdateProfileDto;
import com.JobHorbour.JobHorbour.Entity.Company;
import com.JobHorbour.JobHorbour.Entity.Profile;
import com.JobHorbour.JobHorbour.Entity.User;
import com.JobHorbour.JobHorbour.Repository.CompanyRepository;
import com.JobHorbour.JobHorbour.Repository.ProfileRepository;
import com.JobHorbour.JobHorbour.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.sql.Types.NULL;

@Service
@Transactional
public class CompanyServiceImpl extends CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void createCompany(Long userId,  CreateCompanyDto createCompanyDto) throws Exception {
        Optional<Company> existingUserOpt = companyRepository.findByCompanyEmail(createCompanyDto.getCompanyEmail());
        if (existingUserOpt.isPresent()) {
            throw new Exception("Company Already exists!");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with ID: " + userId));
        Company company = new Company();
        company.setUser(createCompanyDto.getUser());
        company.setCompanyName(createCompanyDto.getCompanyName());
        company.setCompanyEmail(createCompanyDto.getCompanyEmail());
        company.setCompanyContactNumber(createCompanyDto.getCompanyContactNumber());
        company.setIndustry(createCompanyDto.getIndustry());
        company.setCountry(createCompanyDto.getCountry());
        company.setCity(createCompanyDto.getCity());
        company.setDescription(createCompanyDto.getDescription());
        company.setFoundedYear(createCompanyDto.getFoundedYear());

        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Long userId, UpdateCompanyDto updateCompanyDto) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with ID: " + userId));
        Company company = companyRepository.findByUserId(userId).orElseThrow(() -> new Exception("User not found "));
        if(updateCompanyDto.getCompanyName()!=null){
            company.setCompanyName(updateCompanyDto.getCompanyName());
        }
        if(updateCompanyDto.getCompanyEmail()!=null){
            company.setCompanyEmail(updateCompanyDto.getCompanyEmail());
        }
        if(updateCompanyDto.getCompanyContactNumber()!=null){
            company.setCompanyContactNumber(updateCompanyDto.getCompanyContactNumber());
        }
        if(updateCompanyDto.getIndustry()!=null){
            company.setIndustry(updateCompanyDto.getIndustry());
        }
        if(updateCompanyDto.getCountry()!=null){
            company.setCountry(updateCompanyDto.getCountry());
        }
        if(updateCompanyDto.getCity()!=null){
            company.setCity(updateCompanyDto.getCity());
        }
        if(updateCompanyDto.getDescription()!=null){
            company.setDescription(updateCompanyDto.getDescription());
        }
        if(updateCompanyDto.getFoundedYear()!=null){
            company.setFoundedYear(updateCompanyDto.getFoundedYear());
        }
        companyRepository.save(company);
    }

    @Override
    public void deleteProfile(Long userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with ID: " + userId));
        Company company = companyRepository.findByUserId(userId).orElseThrow(() -> new Exception("User not found "));
        companyRepository.deleteByUserId(userId);
    }

    @Override
    public Company getCompanyByUserId(Long userId) throws Exception {
        return companyRepository.findByUserId(userId)
                .orElseThrow(() -> new Exception("Profile not found for user ID: " + userId));
    }
}

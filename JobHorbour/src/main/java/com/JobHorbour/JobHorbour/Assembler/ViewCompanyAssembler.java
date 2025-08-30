package com.JobHorbour.JobHorbour.Assembler;

import com.JobHorbour.JobHorbour.Dto.CreateCompanyDto;
import com.JobHorbour.JobHorbour.Dto.ViewCompanyDto;
import com.JobHorbour.JobHorbour.Entity.Company;

public class ViewCompanyAssembler extends ComapnyAssembler{
    public static ViewCompanyDto toDto(Company company){
        ViewCompanyDto dto = new ViewCompanyDto();
        dto.setId(company.getId());
        dto.setCompanyName(company.getCompanyName());
        dto.setCompanyEmail(company.getCompanyEmail());
        dto.setCompanyContactNumber(company.getCompanyContactNumber());
        dto.setIndustry(company.getIndustry());
        dto.setCountry(company.getCountry());
        dto.setCity(company.getCity());
        dto.setDescription(company.getDescription());
        dto.setFoundedYear(company.getFoundedYear());
        dto.setTitle(company.getTitle());
        dto.setUserId(company.getUser().getId());
        return dto;
    }
}

package com.JobHorbour.JobHorbour.Assembler;

import com.JobHorbour.JobHorbour.Dto.CreateCompanyDto;
import com.JobHorbour.JobHorbour.Entity.Company;

public class ComapnyAssembler{
    public static CreateCompanyDto toDto(Company company){
        CreateCompanyDto dto = new CreateCompanyDto();
        dto.setCompanyName(company.getCompanyName());
        dto.setCompanyEmail(company.getCompanyEmail());
        dto.setCompanyContactNumber(company.getCompanyContactNumber());
        dto.setIndustry(company.getIndustry());
        dto.setCountry(company.getCountry());
        dto.setCity(company.getCity());
        dto.setDescription(company.getDescription());
        dto.setFoundedYear(company.getFoundedYear());
        return dto;
    }
}

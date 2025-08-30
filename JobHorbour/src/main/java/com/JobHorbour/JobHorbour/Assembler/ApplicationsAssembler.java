package com.JobHorbour.JobHorbour.Assembler;

import com.JobHorbour.JobHorbour.Dto.CreateApplicationsDto;
import com.JobHorbour.JobHorbour.Dto.CreateCompanyDto;
import com.JobHorbour.JobHorbour.Entity.Applications;
import com.JobHorbour.JobHorbour.Entity.Company;

public class ApplicationsAssembler {
    public static CreateApplicationsDto toDto(Applications applications){
        CreateApplicationsDto dto = new CreateApplicationsDto();
        dto.setUser(applications.getUser().getId());
        dto.setCompany(applications.getCompany().getId());
        return dto;
    }
}

package com.JobHorbour.JobHorbour.Service;

import com.JobHorbour.JobHorbour.Dto.CreateApplicationsDto;
import com.JobHorbour.JobHorbour.Dto.CreateCompanyDto;
import com.JobHorbour.JobHorbour.Entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class ApplicationsService {
    public abstract void apply(CreateApplicationsDto createApplicationsDto) throws Exception;

}

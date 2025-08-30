package com.JobHorbour.JobHorbour.Dto;

import com.JobHorbour.JobHorbour.Entity.User;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Data
public class UpdateCompanyDto {
    private String companyName;
    private String companyEmail;
    private String companyContactNumber;
    private String industry;
    private String country;
    private String city;
    private String description;
    private Date foundedYear;
    private String Title;
}

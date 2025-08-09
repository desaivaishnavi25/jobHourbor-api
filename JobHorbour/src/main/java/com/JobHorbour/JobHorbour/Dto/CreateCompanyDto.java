package com.JobHorbour.JobHorbour.Dto;

import com.JobHorbour.JobHorbour.Entity.User;
import jakarta.persistence.Column;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Data
public class CreateCompanyDto {
    @NotNull
    private User user;
    @NotNull
    private String companyName;
    @NotNull
    private String companyEmail;
    @NotNull
    private String companyContactNumber;
    @NotNull
    private String industry;
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private String description;
    @NotNull
    private Date foundedYear;
}

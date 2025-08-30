package com.JobHorbour.JobHorbour.Dto;

import com.JobHorbour.JobHorbour.Entity.Company;
import com.JobHorbour.JobHorbour.Entity.User;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class CreateApplicationsDto {
    @NotNull
    private Long user;
    @NotNull
    private Long company;
}

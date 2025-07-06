package com.JobHorbour.JobHorbour.Dto;

import com.JobHorbour.JobHorbour.Entity.User;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class UpdateProfileDto {
    private String name;
    private String email;
    private String contactNumber;
    private int experience;
    private String description;
    private String links;
}

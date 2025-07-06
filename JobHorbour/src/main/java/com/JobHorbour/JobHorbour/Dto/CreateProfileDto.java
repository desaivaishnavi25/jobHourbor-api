package com.JobHorbour.JobHorbour.Dto;

import com.JobHorbour.JobHorbour.Entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class CreateProfileDto {
    @NotNull
    private User user;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String contactNumber;
    @NotNull
    private int experience;
    @NotNull
    private String description;

    private String links;
}

package com.JobHorbour.JobHorbour.Dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class SignInDto {

    @NotNull
    private String password;

    @NotNull
    private String email;

}

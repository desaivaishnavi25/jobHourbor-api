package com.JobHorbour.JobHorbour.Dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class ViewCompanyDto extends CreateCompanyDto {

    @NotNull
    private Long id;

    private Long userId;
}

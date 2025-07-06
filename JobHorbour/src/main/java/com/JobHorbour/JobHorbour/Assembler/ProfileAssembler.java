package com.JobHorbour.JobHorbour.Assembler;

import com.JobHorbour.JobHorbour.Dto.CreateProfileDto;
import com.JobHorbour.JobHorbour.Entity.Profile;

public class ProfileAssembler {

    public static CreateProfileDto toDto(Profile profile) {
        CreateProfileDto dto = new CreateProfileDto();
        dto.setName(profile.getName());
        dto.setEmail(profile.getEmail());
        dto.setContactNumber(profile.getContactNumber());
        dto.setExperience(profile.getExperience());
        dto.setDescription(profile.getDescription());
        dto.setLinks(profile.getLinks());
        return dto;
    }
}

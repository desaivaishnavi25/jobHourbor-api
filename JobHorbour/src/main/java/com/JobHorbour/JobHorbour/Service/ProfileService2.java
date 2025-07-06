package com.JobHorbour.JobHorbour.Service;

import com.JobHorbour.JobHorbour.Dto.CreateProfileDto;
import org.springframework.stereotype.Service;

public interface ProfileService2 {
     void createProfile(Long userId, CreateProfileDto createProfileDto) throws Exception;
}

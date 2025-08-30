package com.JobHorbour.JobHorbour.Service;

import com.JobHorbour.JobHorbour.Dto.CreateProfileDto;
import com.JobHorbour.JobHorbour.Dto.SignUpDto;
import com.JobHorbour.JobHorbour.Dto.UpdateProfileDto;
import com.JobHorbour.JobHorbour.Entity.Profile;
import com.JobHorbour.JobHorbour.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class ProfileService {
    public abstract void createProfile(Long userId, CreateProfileDto createProfileDto) throws Exception;
    public abstract void updateProfile(Long userId, UpdateProfileDto updateProfileDto) throws Exception;
    public abstract void deleteProfile(Long userId) throws Exception;
    public abstract Profile getProfileByUserId(Long userId) throws Exception;
    public abstract List<Profile> getApplicationsByCompanyId(Long companyId);
}

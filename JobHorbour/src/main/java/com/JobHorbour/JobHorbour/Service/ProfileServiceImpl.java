package com.JobHorbour.JobHorbour.Service;

import com.JobHorbour.JobHorbour.Dto.CreateProfileDto;
import com.JobHorbour.JobHorbour.Dto.UpdateProfileDto;
import com.JobHorbour.JobHorbour.Entity.Profile;
import com.JobHorbour.JobHorbour.Entity.User;
import com.JobHorbour.JobHorbour.Repository.ProfileRepository;
import com.JobHorbour.JobHorbour.Repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.sql.Types.NULL;

@Service
@Transactional
public class ProfileServiceImpl extends ProfileService{
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void createProfile(Long userId,CreateProfileDto createProfileDto) throws Exception {
        Optional<Profile> existingUserOpt = profileRepository.findByEmail(createProfileDto.getEmail());
        if(existingUserOpt.isPresent()){
            throw new Exception("User Already exists!");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with ID: " + userId));
        Profile profile = new Profile();
        profile.setName(createProfileDto.getName());
        profile.setEmail(createProfileDto.getEmail());
        profile.setContactNumber(createProfileDto.getContactNumber());
        profile.setExperience(createProfileDto.getExperience());
        profile.setDescription(createProfileDto.getDescription());
        profile.setUser(user);
        profile.setLinks(createProfileDto.getLinks());
        profileRepository.save(profile);
    }


    @Override
    public void updateProfile(Long userId, UpdateProfileDto updateProfileDto) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with ID: " + userId));
        Profile profile = profileRepository.findByUserId(userId).orElseThrow(() -> new Exception("User not found "));
        if(updateProfileDto.getName()!=null){
            profile.setName(updateProfileDto.getName());
        }
        if(updateProfileDto.getEmail()!=null){
            profile.setEmail(updateProfileDto.getEmail());
        }
        if(updateProfileDto.getContactNumber()!=null){
            profile.setContactNumber(updateProfileDto.getContactNumber());
        }
        if(updateProfileDto.getExperience()!=NULL){
            profile.setExperience(updateProfileDto.getExperience());
        }
        if(updateProfileDto.getDescription()!=null){
            profile.setDescription(updateProfileDto.getDescription());
        }
        if(updateProfileDto.getLinks()!=null){
            profile.setLinks(updateProfileDto.getLinks());
        }
        profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Long userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found with ID: " + userId));
        Profile profile = profileRepository.findByUserId(userId).orElseThrow(() -> new Exception("User not found "));
        profileRepository.deleteByUserId(userId);
    }

    @Override
    public Profile getProfileByUserId(Long userId) throws Exception {
        return profileRepository.findByUserId(userId)
                .orElseThrow(() -> new Exception("Profile not found for user ID: " + userId));
    }
}

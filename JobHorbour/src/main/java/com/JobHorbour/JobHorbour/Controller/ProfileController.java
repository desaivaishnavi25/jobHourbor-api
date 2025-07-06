package com.JobHorbour.JobHorbour.Controller;

import com.JobHorbour.JobHorbour.Assembler.ProfileAssembler;
import com.JobHorbour.JobHorbour.Dto.CreateProfileDto;
import com.JobHorbour.JobHorbour.Dto.SignUpDto;
import com.JobHorbour.JobHorbour.Dto.UpdateProfileDto;
import com.JobHorbour.JobHorbour.Entity.Profile;
import com.JobHorbour.JobHorbour.Service.ProfileService;
import com.JobHorbour.JobHorbour.Service.ProfileService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
public class ProfileController {
    @Autowired
    ProfileService profileService;


    @PostMapping("/user/{userId}/createProfile")
    public String createProfile(@PathVariable("userId") Long userId, @RequestBody CreateProfileDto createProfileDto, WebRequest request, Model model) throws Exception {
        profileService.createProfile(userId,createProfileDto);
        return "registration Completed!";
    }

    @PutMapping("/user/{userId}/updateProfile")
    public String updateProfile(@PathVariable("userId") Long userId, @RequestBody UpdateProfileDto updateProfileDto, WebRequest request, Model model) throws Exception {
        profileService.updateProfile(userId,updateProfileDto);
        return "Updation Completed!";
    }

    @DeleteMapping("/user/{userId}/deleteProfile")
    public String deleteProfile(@PathVariable("userId") Long userId, WebRequest request, Model model) throws Exception {
        profileService.deleteProfile(userId);
        return "Deletion Completed!";
    }

    @GetMapping("/user/{userId}/profile")
    public ResponseEntity<CreateProfileDto> getProfile(@PathVariable Long userId) {
        try {
            Profile profile = profileService.getProfileByUserId(userId);
            CreateProfileDto dto = ProfileAssembler.toDto(profile);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
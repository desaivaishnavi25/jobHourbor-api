package com.JobHorbour.JobHorbour.Controller;

import com.JobHorbour.JobHorbour.Assembler.ProfileAssembler;
import com.JobHorbour.JobHorbour.Assembler.ViewCompanyAssembler;
import com.JobHorbour.JobHorbour.Dto.CreateApplicationsDto;
import com.JobHorbour.JobHorbour.Dto.CreateCompanyDto;
import com.JobHorbour.JobHorbour.Dto.CreateProfileDto;
import com.JobHorbour.JobHorbour.Dto.ViewCompanyDto;
import com.JobHorbour.JobHorbour.Entity.Company;
import com.JobHorbour.JobHorbour.Entity.Profile;
import com.JobHorbour.JobHorbour.Entity.User;
import com.JobHorbour.JobHorbour.Service.ApplicationsService;
import com.JobHorbour.JobHorbour.Service.ApplicationsServiceImpl;
import com.JobHorbour.JobHorbour.Service.CompanyService;
import com.JobHorbour.JobHorbour.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApplicationsController {
    @Autowired
    ApplicationsService applicationService;
    @Autowired
    CompanyService companyService;
    @Autowired
    ProfileService profileService;

    @PostMapping("/user/apply")
    public String apply(@RequestBody CreateApplicationsDto createApplicationsDto, WebRequest request, Model model) throws Exception {
        applicationService.apply(createApplicationsDto);
        return "Applied!";
    }

    @GetMapping("/user/application" +
            "/{userId}")
    public ResponseEntity<List<ViewCompanyDto>> getAppliedCompaniesByUserId(@PathVariable Long userId) {
        try {
            List<Company> company = companyService.getAppliedCompaniesByUserId(userId);
            List<ViewCompanyDto> dtos = company.stream().map(ViewCompanyAssembler::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/apply/{companyId}")
    public ResponseEntity<List<CreateProfileDto>> getApplications(@PathVariable Long companyId) {
        try {
            List<Profile> profile = profileService.getApplicationsByCompanyId(companyId);
            List<CreateProfileDto> dtos = profile.stream().map(ProfileAssembler::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}

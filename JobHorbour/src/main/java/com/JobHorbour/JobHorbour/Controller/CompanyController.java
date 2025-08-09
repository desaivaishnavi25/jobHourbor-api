package com.JobHorbour.JobHorbour.Controller;

import com.JobHorbour.JobHorbour.Assembler.ComapnyAssembler;
import com.JobHorbour.JobHorbour.Assembler.ProfileAssembler;
import com.JobHorbour.JobHorbour.Dto.CreateCompanyDto;
import com.JobHorbour.JobHorbour.Dto.CreateProfileDto;
import com.JobHorbour.JobHorbour.Dto.UpdateCompanyDto;
import com.JobHorbour.JobHorbour.Dto.UpdateProfileDto;
import com.JobHorbour.JobHorbour.Entity.Company;
import com.JobHorbour.JobHorbour.Entity.Profile;
import com.JobHorbour.JobHorbour.Service.CompanyService;
import com.JobHorbour.JobHorbour.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;


    @PostMapping("/user/{userId}/createCompany")
    public String createCompany(@PathVariable("userId") Long userId, @RequestBody CreateCompanyDto createCompanyDto, WebRequest request, Model model) throws Exception {
        companyService.createCompany(userId,createCompanyDto);
        return "registration Completed!";
    }

    @PutMapping("/user/{userId}/updateCompany")
    public String updateProfile(@PathVariable("userId") Long userId, @RequestBody UpdateCompanyDto updateCompanyDto, WebRequest request, Model model) throws Exception {
        companyService.updateCompany(userId,updateCompanyDto);
        return "Updation Completed!";
    }

    @DeleteMapping("/user/{userId}/deleteCompany")
    public String deleteCompany(@PathVariable("userId") Long userId, WebRequest request, Model model) throws Exception {
        companyService.deleteProfile(userId);
        return "Deletion Completed!";
    }

    @GetMapping("/user/{userId}/company")
    public ResponseEntity<CreateCompanyDto> getCompany(@PathVariable Long userId) {
        try {
            Company company = companyService.getCompanyByUserId(userId);
            CreateCompanyDto dto = ComapnyAssembler.toDto(company);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

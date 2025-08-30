package com.JobHorbour.JobHorbour.Controller;

import com.JobHorbour.JobHorbour.Assembler.ComapnyAssembler;
import com.JobHorbour.JobHorbour.Assembler.ProfileAssembler;
import com.JobHorbour.JobHorbour.Assembler.ViewCompanyAssembler;
import com.JobHorbour.JobHorbour.Dto.*;
import com.JobHorbour.JobHorbour.Entity.Company;
import com.JobHorbour.JobHorbour.Entity.Profile;
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
public class CompanyController {
    @Autowired
    CompanyService companyService;


    @PostMapping("/user/{userId}/createCompany")
    public String createCompany(@PathVariable("userId") Long userId, @RequestBody CreateCompanyDto createCompanyDto, WebRequest request, Model model) throws Exception {
        companyService.createCompany(userId,createCompanyDto);
        return "registration Completed!";
    }

    @PutMapping("/user/updateCompany/{companyId}")
    public String updateProfile(@PathVariable("companyId") Long companyId, @RequestBody UpdateCompanyDto updateCompanyDto, WebRequest request, Model model) throws Exception {
        companyService.updateCompany(companyId,updateCompanyDto);
        return "Updation Completed!";
    }

    @DeleteMapping("/user/deleteCompany/{companyId}")
    public String deleteCompany(@PathVariable("companyId") Long companyId, WebRequest request, Model model) throws Exception {
        companyService.deleteProfile(companyId);
        return "Deletion Completed!";
    }

    @GetMapping("/user/{userId}/company")
    public ResponseEntity<List<ViewCompanyDto>> getCompanyByUserId(@PathVariable Long userId) {
        try {
            List<Company> company = companyService.getCompanyByUserId(userId);
            List<ViewCompanyDto> dtos = company.stream().map(ViewCompanyAssembler::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/company/{companyId}")
    public ResponseEntity<ViewCompanyDto> getCompanyDetails(@PathVariable Long companyId) {
        try {
            Company company = companyService.getCompanyById(companyId);
            ViewCompanyDto dto = ViewCompanyAssembler.toDto(company);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/company")
    public ResponseEntity<List<ViewCompanyDto>> getAllCompanies() {
        try {
            List<Company> companies = companyService.getAllCompanies();
            List<ViewCompanyDto> dtos = companies.stream()
                    .map(ViewCompanyAssembler::toDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}

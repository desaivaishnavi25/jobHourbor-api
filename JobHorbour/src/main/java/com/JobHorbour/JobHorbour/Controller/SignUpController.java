package com.JobHorbour.JobHorbour.Controller;

import com.JobHorbour.JobHorbour.Dto.SignUpDto;

import com.JobHorbour.JobHorbour.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class SignUpController {

    @Autowired
    AuthService authService;

    @PostMapping("/user/registration")
    public String register(@RequestBody SignUpDto SignUpDto, WebRequest request, Model model) throws Exception {
        authService.registerUser(SignUpDto);
        return "registration Completed!";
    }
}

package com.JobHorbour.JobHorbour.Controller;

import com.JobHorbour.JobHorbour.Dto.SignInDto;
import com.JobHorbour.JobHorbour.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class SignInController {

    @Autowired
    AuthService authService;

    @GetMapping("/user/login")
    public String register(@RequestBody SignInDto SignInDto, WebRequest request, Model model) throws Exception {
        authService.loginUser(SignInDto);
        return "Logged In!";
    }
}

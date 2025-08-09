package com.JobHorbour.JobHorbour.Controller;

import com.JobHorbour.JobHorbour.Dto.SignInDto;
import com.JobHorbour.JobHorbour.Entity.User;
import com.JobHorbour.JobHorbour.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SignInController {

    @Autowired
    AuthService authService;

    @PostMapping("/user/login")
    public ResponseEntity<Map<String, Object>> register(@RequestBody SignInDto SignInDto, WebRequest request, Model model) throws Exception {
        User user = authService.loginUser(SignInDto);
        Map<String, Object> response = new HashMap<>();
        response.put("userId", user.getId());
        response.put("message", "Login successful");

        return ResponseEntity.ok(response);
    }
}

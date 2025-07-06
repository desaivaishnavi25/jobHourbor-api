package com.JobHorbour.JobHorbour.Service;

import com.JobHorbour.JobHorbour.Dto.SignInDto;
import com.JobHorbour.JobHorbour.Dto.SignUpDto;
import org.springframework.stereotype.Service;

@Service
public abstract class AuthService {
    public abstract void registerUser(SignUpDto signUpDto) throws Exception;
    public abstract void loginUser(SignInDto signUpDto) throws Exception;
}

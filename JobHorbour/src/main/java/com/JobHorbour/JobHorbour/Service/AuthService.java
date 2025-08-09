package com.JobHorbour.JobHorbour.Service;

import com.JobHorbour.JobHorbour.Dto.SignInDto;
import com.JobHorbour.JobHorbour.Dto.SignUpDto;
import com.JobHorbour.JobHorbour.Entity.User;
import org.springframework.stereotype.Service;

@Service
public abstract class AuthService {
    public abstract void registerUser(SignUpDto signUpDto) throws Exception;
    public abstract User loginUser(SignInDto signUpDto) throws Exception;
}

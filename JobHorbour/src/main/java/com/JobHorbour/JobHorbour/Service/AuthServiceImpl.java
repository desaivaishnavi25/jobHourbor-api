package com.JobHorbour.JobHorbour.Service;

import com.JobHorbour.JobHorbour.Dto.SignInDto;
import com.JobHorbour.JobHorbour.Dto.SignUpDto;
import com.JobHorbour.JobHorbour.Entity.User;
import com.JobHorbour.JobHorbour.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl extends AuthService {

    @Autowired
    AuthRepository authRepository;

    @Override
    public void registerUser(SignUpDto signUpDto) throws Exception {
        Optional<User> existingUserOpt = authRepository.findByEmail(signUpDto.getEmail());
        if(existingUserOpt.isPresent()){
            throw new Exception("User Already exists!");
        }
        User user = new User();
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(signUpDto.getPassword());
        user.setRole(signUpDto.getRole());
        authRepository.save(user);
    }

    @Override
    public void loginUser(SignInDto signInDto) throws Exception {
        Optional<User> userOpt = authRepository.findByEmail(signInDto.getEmail());
        if(userOpt.isEmpty()){
            throw new Exception("User Not found");
        }
        User user = userOpt.get();
        if (!user.getPassword().equals(signInDto.getPassword())) {
            throw new Exception("Invalid credentials. Please check your password.");
        }


    }
}

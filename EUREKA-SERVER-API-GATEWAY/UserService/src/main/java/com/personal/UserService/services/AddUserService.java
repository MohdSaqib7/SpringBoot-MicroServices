package com.personal.UserService.services;

import com.personal.UserService.models.User;
import com.personal.UserService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddUserService {

    @Autowired
    private UserRepo userRepo;

    public String addUser(User user){
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        userRepo.save(user);
        return "Successfully register";
    }
}

package com.personal.UserService.services;

import com.personal.UserService.models.User;
import com.personal.UserService.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetUserService {

    private UserRepo userRepo;

    public List<User> getUser(String profession){
        List<User> users = userRepo.findByProfession(profession);
        return users;
    }

    public List<User> getAllUsers(){
        List<User> users = userRepo.findAll();
        if(users.size()>0){
            return users;
        }
        return new ArrayList<>();
    }
}

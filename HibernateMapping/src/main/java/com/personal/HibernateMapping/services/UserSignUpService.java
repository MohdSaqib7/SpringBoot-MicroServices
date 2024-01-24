package com.personal.HibernateMapping.services;

import com.personal.HibernateMapping.models.User;
import com.personal.HibernateMapping.repositories.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSignUpService {

    @Autowired
    UserJpaRepo userJpaRepo;
    public String register(User user){
        Optional<User> repoData = userJpaRepo.findByEmail(user.getEmail());
        if(repoData.isPresent()){
            return "User Already Exist";
        }
        userJpaRepo.save(user);
        return "Successfully saved";
    }
}

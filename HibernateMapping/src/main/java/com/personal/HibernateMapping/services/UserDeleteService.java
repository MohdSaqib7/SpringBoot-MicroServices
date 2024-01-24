package com.personal.HibernateMapping.services;

import com.personal.HibernateMapping.models.User;
import com.personal.HibernateMapping.repositories.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDeleteService {

    @Autowired
    UserJpaRepo userJpaRepo;

    public String delete(String email, String password){
        Optional<User> user = userJpaRepo.findByEmailAndPassword(email,password);
        if(user.isPresent()){
            userJpaRepo.deleteById(user.get().getId());
            return "Delete successfully";
        }
        return  "User Not Found";
    }
}

package com.personal.HibernateMapping.services;

import com.personal.HibernateMapping.models.User;
import com.personal.HibernateMapping.repositories.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginService {

    @Autowired
    UserJpaRepo userJpaRepo;
    public User getUser(String email, String password){
        Optional<User> user = userJpaRepo.findByEmailAndPassword(email,password);
        if(user.isEmpty()){
            return new User();
        }
        return user.get();

    }
}

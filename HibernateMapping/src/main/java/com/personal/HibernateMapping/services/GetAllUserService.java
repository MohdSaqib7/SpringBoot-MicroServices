package com.personal.HibernateMapping.services;

import com.personal.HibernateMapping.models.User;
import com.personal.HibernateMapping.repositories.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllUserService {

    @Autowired
    UserJpaRepo userJpaRepo;

    public List<User> getAllUsers(){
        List<User> users = userJpaRepo.findAll();
        if(users.isEmpty()){
            return new ArrayList<>();
        }
        return users;
    }
}

package com.personal.HibernateMapping.services;

import com.personal.HibernateMapping.models.User;
import com.personal.HibernateMapping.repositories.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetUserService {

    @Autowired
    UserJpaRepo userJpaRepo;
    public List getUser(String name){
        List<User> users = userJpaRepo.findByName(name);
        if(!users.isEmpty()){
            return users;
        }
        return new ArrayList<>();

    }
}

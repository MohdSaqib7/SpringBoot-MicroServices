package com.personal.HibernateMapping.controllers;

import com.personal.HibernateMapping.models.User;
import com.personal.HibernateMapping.services.GetAllUserService;
import com.personal.HibernateMapping.services.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    GetAllUserService getAllUserService;

    @Autowired
    GetUserService getUserService;


    @GetMapping("/getUser")
    public List<User> getUser(@RequestParam String name){
        return getUserService.getUser(name);
    }


    @GetMapping("/getAllUser")
    public List<User> getAllUsers(){
        return getAllUserService.getAllUsers();
    }
}

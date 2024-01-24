package com.personal.HibernateMapping.controllers;

import com.personal.HibernateMapping.models.User;
import com.personal.HibernateMapping.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserSignUpService userSignUpService;

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    UserDeleteService userDeleteService;


    @PostMapping("/saved")
    public String register(@RequestBody User user){
        return userSignUpService.register(user);
    }

    @GetMapping("/login")
    public User login(@RequestParam String email, @RequestParam String password){
        return userLoginService.getUser(email,password);
    }


    @GetMapping("/delete")
    public String delete(@RequestParam String email, @RequestParam String password){
        return userDeleteService.delete(email,password);
    }

}

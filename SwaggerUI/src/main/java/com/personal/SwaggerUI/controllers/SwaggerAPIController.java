package com.personal.SwaggerUI.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SwaggerAPIController {

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        return "you are successfully registered";
    }


    @GetMapping("/login")
    public String login(@RequestParam String name, @RequestParam String email){
        return "you are successfully login with : "+name;
    }


    @GetMapping("/get")
    public String getUser(@RequestParam String name){
        return "Username : " + name+ "07," + "     Email: " + name+"905@gmail.com";
    }


    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam Integer id){
        return "User ID: "+id +" is successfully deleted";
    }
}

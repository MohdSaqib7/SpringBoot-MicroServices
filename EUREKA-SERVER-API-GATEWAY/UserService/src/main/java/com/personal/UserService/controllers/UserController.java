package com.personal.UserService.controllers;

import com.personal.UserService.externalEntities.Rating;
import com.personal.UserService.externalServices.HotelService;
import com.personal.UserService.externalServices.RatingService;
import com.personal.UserService.models.User;
import com.personal.UserService.responseEntities.ResponseHotel;
import com.personal.UserService.services.AddUserService;
import com.personal.UserService.services.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AddUserService addUserService;

    @Autowired
    private GetUserService getUserService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;


    @GetMapping("/add")
    public String addUser(@RequestBody User user){
        return addUserService.addUser(user);
    }

    @GetMapping("/get/{profession}")
    public List<User> getUsersProfession(@PathVariable String profession){
        return getUserService.getUser(profession);
    }

    @GetMapping("/all")
    public List<User> getAllUser(){
        return getUserService.getAllUsers();
    }

    @GetMapping("/hotel-service/hotels/all")
    public List<ResponseHotel> getAllHotels(){
        return hotelService.getAll();
    }

    @GetMapping("/rating-service/rating")
    public String rating(@RequestBody Rating rating){
        return ratingService.giveRating(rating);
    }

}

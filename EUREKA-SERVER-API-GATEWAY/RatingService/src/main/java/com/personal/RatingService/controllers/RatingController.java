package com.personal.RatingService.controllers;

import com.personal.RatingService.models.Rating;
import com.personal.RatingService.services.GetRatingService;
import com.personal.RatingService.services.GiveRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private GetRatingService getRatingService;

    @Autowired
    private GiveRatingService giveRatingService;

    @GetMapping("/add")
    public String addRating(@RequestBody Rating rating){
        return giveRatingService.giveRating(rating);
    }

    @GetMapping("/getRating/{hotelName}")
    public Map<String, List<Integer>> getHotelRating(@PathVariable String hotelName){
        return getRatingService.getHotelRating(hotelName);
    }

    @GetMapping("/getAllRatings")
    public Map<String, List<Integer>> getAll(){
        return getRatingService.getAllHotelsRatings();
    }
}

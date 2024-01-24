package com.personal.RatingService.services;

import com.personal.RatingService.models.Rating;
import com.personal.RatingService.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiveRatingService {

    @Autowired
    private RatingRepo ratingRepo;

    public String giveRating(Rating rating){
        ratingRepo.save(rating);
        return "ThankYou for your valuable giving feedback";
    }

}

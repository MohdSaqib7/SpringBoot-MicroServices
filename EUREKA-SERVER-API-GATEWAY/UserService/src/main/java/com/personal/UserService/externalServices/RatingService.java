package com.personal.UserService.externalServices;

import com.personal.UserService.externalEntities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/rating/add")
    String giveRating(@RequestBody Rating rating);
}

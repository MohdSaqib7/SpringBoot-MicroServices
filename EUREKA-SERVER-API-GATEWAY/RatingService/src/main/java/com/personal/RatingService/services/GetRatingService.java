package com.personal.RatingService.services;

import com.personal.RatingService.models.Rating;
import com.personal.RatingService.repo.RatingRepo;
import jakarta.persistence.Access;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetRatingService {

    @Autowired
    private RatingRepo ratingRepo;

    public Map<String, List<Integer>> getHotelRating(String hotelName){
        List<Rating> ratings = ratingRepo.findByHotelName(hotelName);
        Map<String, List<Integer>> response = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        for(Rating rating : ratings){
            Integer val = rating.getRating();
            list.add(val);
        }
        response.put(hotelName,list);
        return response;
    }

    public Map<String, List<Integer>> getAllHotelsRatings(){
        List<Rating> ratings = ratingRepo.findAll();
        Map<String, List<Integer>> map = new HashMap<>();

        for(Rating rating :  ratings){
            String name = rating.getHotelName();
            Integer val = rating.getRating();

            if(map.containsKey(name)){
                List<Integer> list = map.get(name);
                list.add(val);
                map.put(name,list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(val);
                map.put(name,list);
            }
        }
        return map;
    }
}

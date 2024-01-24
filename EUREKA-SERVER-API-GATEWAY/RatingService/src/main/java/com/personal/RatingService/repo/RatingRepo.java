package com.personal.RatingService.repo;

import com.personal.RatingService.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating, Integer> {

    List<Rating> findByHotelName(String name);
}

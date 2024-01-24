package com.personal.HotelService.repo;

import com.personal.HotelService.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {

    List<Hotel> findByHotelType(String hotelType);
    Optional<Hotel> findByName(String name);
}

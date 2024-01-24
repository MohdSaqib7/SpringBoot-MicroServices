package com.personal.HotelService.services;

import com.personal.HotelService.models.Hotel;
import com.personal.HotelService.repo.HotelRepository;
import org.springframework.stereotype.Service;

@Service
public class AddHotelService {

    private HotelRepository hotelRepository;

    public String saveHotel(Hotel hotel){
        hotelRepository.save(hotel);
        return "Now yor are on our member hotel";
    }
}

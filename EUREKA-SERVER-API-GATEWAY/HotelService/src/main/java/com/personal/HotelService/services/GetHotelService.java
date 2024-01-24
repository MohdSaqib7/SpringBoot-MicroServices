package com.personal.HotelService.services;

import com.personal.HotelService.entities.ResponseOut;
import com.personal.HotelService.models.Hotel;
import com.personal.HotelService.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class GetHotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<ResponseOut> getAllHotels(){
        List<Hotel> hotels = hotelRepository.findAll();
        List<ResponseOut> resp = new ArrayList<>();

        for(Hotel hotel : hotels){
            String name = hotel.getName();
            HashMap<String, ArrayList<Integer>> results = restTemplate.getForObject("http://RATING-SERVICE/rating/get"+name, HashMap.class);
            ResponseOut out = new ResponseOut();
            out.setId(hotel.getId());
            out.setName(hotel.getName());
            out.setLocation(hotel.getLocation());
            out.setHotelType(hotel.getHotelType());
            out.setRatings(results);

            resp.add(out);
        }

        return resp;
    }

    public ResponseOut getHotel(String name){
        Optional<Hotel> obj = hotelRepository.findByName(name);
        Hotel hotel = obj.get();
        ResponseOut out = new ResponseOut();

        out.setId(hotel.getId());
        out.setName(hotel.getName());
        out.setLocation(hotel.getLocation());
        out.setHotelType(hotel.getHotelType());

        HashMap<String, ArrayList<Integer>> result = restTemplate.getForObject("http://RATING-SERVICE/rating/get"+name, HashMap.class);
        out.setRatings(result);

        return out;
    }




}

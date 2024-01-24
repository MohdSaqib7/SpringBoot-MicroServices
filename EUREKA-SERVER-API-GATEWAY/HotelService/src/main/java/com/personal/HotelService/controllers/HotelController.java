package com.personal.HotelService.controllers;

import com.personal.HotelService.entities.ResponseOut;
import com.personal.HotelService.models.Hotel;
import com.personal.HotelService.services.AddHotelService;
import com.personal.HotelService.services.GetHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private AddHotelService addHotelService;

    @Autowired
    private GetHotelService getHotelService;

    @PostMapping("/add")
    public String addHotel(@RequestBody Hotel hotel){
        return addHotelService.saveHotel(hotel);
    }

    @GetMapping("/name/{name}")
    public ResponseOut getHotel(@PathVariable String name){
        return getHotelService.getHotel(name);
    }

    @GetMapping("/all")
    public List<ResponseOut> getAllHotels(){
        return getHotelService.getAllHotels();
    }

}

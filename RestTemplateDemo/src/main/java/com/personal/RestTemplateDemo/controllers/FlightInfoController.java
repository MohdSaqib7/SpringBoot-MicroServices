package com.personal.RestTemplateDemo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.personal.RestTemplateDemo.models.Flight;
import com.personal.RestTemplateDemo.outerServices.Train;
import com.personal.RestTemplateDemo.outerServices.TrainsInfoService;
import com.personal.RestTemplateDemo.services.GetAllFlightsService;
import com.personal.RestTemplateDemo.services.GetFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airways")
public class FlightInfoController {

    @Autowired
    private GetAllFlightsService getAllFlightsService;

    @Autowired
    private GetFlightService getFlightService;

    @Autowired
    private TrainsInfoService trainsInfoService;

    @GetMapping("/getFlight")
    public Flight getFlight(@RequestParam String name){
        return getFlightService.getFlight(name);
    }

    @GetMapping("/getAllFlights")
    public List<Flight> getAllFlights(@RequestParam String from, @RequestParam String to){
        return getAllFlightsService.getAllFlights(from,to);
    }

    @GetMapping("/getTrain")
    public Train getTrain(@RequestParam int number){
        return trainsInfoService.getTrain(number);
    }

    @GetMapping("getAllTrain")
    public List<Train> getAllTrain(@RequestParam String from, @RequestParam String to) throws JsonProcessingException {
        return trainsInfoService.getAllTrain(from,to);
    }

}

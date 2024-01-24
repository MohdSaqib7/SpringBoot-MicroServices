package com.personal.FeignClientDemo.controllers;

import com.personal.FeignClientDemo.client.Flight;
import com.personal.FeignClientDemo.client.FlightsInfoService;
import com.personal.FeignClientDemo.models.Train;
import com.personal.FeignClientDemo.services.GetAllTrainService;
import com.personal.FeignClientDemo.services.GetTrainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/railways")
public class TrainInfoController {

    @Autowired
    GetAllTrainService getAllTrainService;

    @Autowired
    GetTrainService getTrainService;

    @Autowired
    FlightsInfoService flightsInfoService;

    @GetMapping("/getTrain")
    public Train getTrain(@RequestParam Integer number){
        return getTrainService.getTrain(number);
    }

    @GetMapping("/getAllTrains")
    public List<Train> getTrains(@RequestParam String from, @RequestParam String to){
        return getAllTrainService.getAllTrains(from,to);
    }

    @GetMapping("/getFlight")
    public Flight getFlight(@RequestParam String flightName){
        log.info("Response --> %s", flightsInfoService.getFight(flightName));
        return flightsInfoService.getFight(flightName);
    }

    @GetMapping("/getAllFlights")
    public List<Flight> getAllFlights(@RequestParam String from, @RequestParam String to){
        return flightsInfoService.getAllFlights(from,to);
    }

}

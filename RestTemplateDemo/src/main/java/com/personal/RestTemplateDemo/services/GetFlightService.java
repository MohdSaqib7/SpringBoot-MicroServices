package com.personal.RestTemplateDemo.services;

import com.personal.RestTemplateDemo.models.Flight;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class GetFlightService {

    public Flight getFlight(String name){
        Flight flight = Flight.builder()
                .id(55)
                .flightName(name)
                .departureFrom("Delhi")
                .destination("Hydrabad")
                .time(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                .build();
        return flight;
    }
}

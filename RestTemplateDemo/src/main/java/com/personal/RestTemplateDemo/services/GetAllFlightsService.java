package com.personal.RestTemplateDemo.services;

import com.personal.RestTemplateDemo.models.Flight;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllFlightsService {

    public List<Flight> getAllFlights(String from, String to){
        List<Flight> flights = new ArrayList<>();
        String[] ar = {"Vistara-235","Indigo-45BE","Vistara-073A","AirIndia-3B04"};
        for(int i=1; i<=4; i++){
            Flight flight = Flight.builder()
                    .id(i)
                    .flightName(ar[i-1])
                    .departureFrom(from)
                    .destination(to)
                    .time(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                    .build();
            flights.add(flight);
        }
        return flights;
    }

}

package com.personal.FeignClientDemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(value = "flightsInfoService", url="http://localhost:5051/airways")
public interface FlightsInfoService {

    @GetMapping("/getFlight")
    Flight getFight(@RequestParam String name);

    @GetMapping("/getAllFlights")
    List<Flight> getAllFlights(@RequestParam String from, String to);
}

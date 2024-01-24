package com.personal.FeignClientDemo.services;

import com.personal.FeignClientDemo.models.Train;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllTrainService {

    public List<Train> getAllTrains(String from, String to){
        List<Train> trains = new ArrayList<>();
        int[] ar = {12063,67043,13067,34001};
        for(int i=1; i<=4; i++){
            Train train = Train.builder()
                    .id(i)
                    .trainNumber(ar[i-1])
                    .departureFrom(from)
                    .destination(to)
                    .time(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                    .build();
            trains.add(train);
        }
        return trains;
    }
}

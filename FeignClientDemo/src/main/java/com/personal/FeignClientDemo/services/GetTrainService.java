package com.personal.FeignClientDemo.services;

import com.personal.FeignClientDemo.models.Train;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;


@Service
public class GetTrainService {

    public Train getTrain(int trainNumber){
        Train train = Train.builder()
                .id(10)
                .trainNumber(trainNumber)
                .departureFrom("Delhi")
                .destination("Mumbai")
                .time(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                .build();
        return train;
    }
}

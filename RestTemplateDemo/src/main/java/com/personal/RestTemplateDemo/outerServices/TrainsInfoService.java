package com.personal.RestTemplateDemo.outerServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainsInfoService {

    private RestTemplate restTemplate = new RestTemplate();

    public Train getTrain(Integer number){
        String url = String.format("http://localhost:5052/railways/getTrain?number=%s",number);
        ResponseEntity<Train> train = restTemplate.getForEntity(url,Train.class);
        return train.getBody();
    }

    public List<Train> getAllTrain(String from, String to) throws JsonProcessingException {

        String url = ""+String.format("http://localhost:5052/irctc/getAllTrains?from=%s&to=%s",from,to);
        ArrayList<Train> trains = restTemplate.getForEntity(url, ArrayList.class).getBody();
        return trains;
    }
}

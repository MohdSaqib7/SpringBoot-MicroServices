package com.personal.HotelService.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Data
public class ResponseOut {

    private int id;
    private String name;
    private String location;
    private String hotelType;
    private HashMap<String, ArrayList<Integer>> ratings;

}

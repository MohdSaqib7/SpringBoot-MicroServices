package com.personal.RestTemplateDemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    int id;

    String flightName;

    String departureFrom;

    String destination;

    DateTimeFormatter time;


}

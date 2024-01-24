package com.personal.FeignClientDemo.client;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty
    Integer id;

    @JsonProperty
    String flightName;

    @JsonProperty
    String departureFrom;

    @JsonProperty
    String destination;

    @JsonProperty
    DateTimeFormatter time;


}

package com.personal.RestTemplateDemo.outerServices;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.format.DateTimeFormatter;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Train {

    @JsonProperty
    int id;

    @JsonProperty
    int trainNumber;

    @JsonProperty
    String departureFrom;

    @JsonProperty
    String destination;

    @JsonProperty
    DateTimeFormatter time;
}
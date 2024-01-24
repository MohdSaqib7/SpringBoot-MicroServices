package com.personal.FeignClientDemo.models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Component
@Data
@Builder
@Service
@AllArgsConstructor
@NoArgsConstructor
public class Train {

    public Integer id;

    public Integer trainNumber;

    public String departureFrom;

    public String destination;

    public DateTimeFormatter time;
}

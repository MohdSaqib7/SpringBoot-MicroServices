package com.personal.TraditionalJdbc.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Doctor {

    private Integer id;

    private String doctorName;

    private String specialization;

    private Integer contact;

    private String doctorCode;
}

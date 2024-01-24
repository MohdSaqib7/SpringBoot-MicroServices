package com.personal.HotelService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Hotel {

    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String location;

    @Column(name = "hotel_type")
    private String hotelType;
}

package com.personal.UserService.externalEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Rating {

    @Column
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column
    private int rating;
}

package com.personal.UserService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User {

    @Column
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column
    private String name;

    @Column
    private String profession;

}

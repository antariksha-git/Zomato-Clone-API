package org.ex.zomato.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.ex.zomato.enums.DietType;

import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    private String restaurantId;

    private String name;
    private String description;
    private String phoneNumber;
    private String email;
    @ElementCollection
    private List<DietType> dietTypes;
}

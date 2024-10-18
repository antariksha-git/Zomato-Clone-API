package org.ex.zomato.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.ex.zomato.config.GenerateCustomId;
import org.ex.zomato.enums.DietType;

import java.util.List;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
public class Restaurant {
    @Id
    @GenerateCustomId
    @Column(name = "restaurant_id")
    private String restaurantId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "diet_types")
    @ElementCollection
    private List<DietType> dietTypes;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}

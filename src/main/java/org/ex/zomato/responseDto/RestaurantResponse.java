package org.ex.zomato.responseDto;

import lombok.Getter;
import lombok.Setter;
import org.ex.zomato.entity.Address;
import org.ex.zomato.enums.DietType;

import java.util.List;

@Getter
@Setter
public class RestaurantResponse {
    private String restaurantId;
    private String name;
    private String description;
    private String phoneNumber;
    private String email;
    private List<DietType> dietTypes;
    private Address address;
}

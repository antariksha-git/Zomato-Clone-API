package org.ex.zomato.responseDto;

import lombok.Getter;
import lombok.Setter;
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
    //List of diet types
    private List<DietType> dietTypes;
}

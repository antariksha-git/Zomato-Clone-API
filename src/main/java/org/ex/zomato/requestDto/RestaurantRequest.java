package org.ex.zomato.requestDto;

import lombok.Getter;
import lombok.Setter;
import org.ex.zomato.enums.DietType;

import java.util.List;

@Getter
@Setter
public class RestaurantRequest {
    private String name;
    private String description;
    private String phoneNumber;
    private String email;
    private List<DietType> dietTypes;
}

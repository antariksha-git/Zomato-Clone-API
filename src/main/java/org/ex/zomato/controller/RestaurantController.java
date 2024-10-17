package org.ex.zomato.controller;

import org.ex.zomato.requestDto.RestaurantRequest;
import org.ex.zomato.responseDto.RestaurantResponse;
import org.ex.zomato.service.RestaurantService;
import org.ex.zomato.util.AppResponseBuilder;
import org.ex.zomato.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${zomato.base_url}")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
        return AppResponseBuilder.create(HttpStatus.CREATED, "Restaurant Added", restaurantResponse);
    }

}

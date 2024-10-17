package org.ex.zomato.controller;

import jakarta.validation.Valid;
import org.ex.zomato.requestDto.RestaurantRequest;
import org.ex.zomato.responseDto.RestaurantResponse;
import org.ex.zomato.service.RestaurantService;
import org.ex.zomato.util.AppResponseBuilder;
import org.ex.zomato.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
        return AppResponseBuilder.create(HttpStatus.CREATED, "Restaurant Added", restaurantResponse);
    }
}

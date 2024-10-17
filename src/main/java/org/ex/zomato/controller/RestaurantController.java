package org.ex.zomato.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
        return AppResponseBuilder.create(HttpStatus.CREATED, "Restaurant Added", restaurantResponse);
    }

    @GetMapping("/restaurant/{restaurant_id}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> findRestaurantById(@PathVariable("restaurant_id") String restaurantId) {
        RestaurantResponse restaurantResponse = restaurantService.findRestaurantById(restaurantId);
        return AppResponseBuilder.create(HttpStatus.OK, "Restaurant Found", restaurantResponse);
    }
}

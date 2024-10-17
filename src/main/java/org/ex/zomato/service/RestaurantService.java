package org.ex.zomato.service;

import org.ex.zomato.entity.Restaurant;
import org.ex.zomato.mapper.RestaurantMapper;
import org.ex.zomato.repository.RestaurantRepository;
import org.ex.zomato.responseDto.RestaurantResponse;
import org.ex.zomato.requestDto.RestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.save(RestaurantMapper
                .mapToRestaurant(restaurantRequest, new Restaurant()));

        return RestaurantMapper.mapToRestaurantResponse(restaurant);
    }
}

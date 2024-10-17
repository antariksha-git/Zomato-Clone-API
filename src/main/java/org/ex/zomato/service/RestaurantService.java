package org.ex.zomato.service;

import org.ex.zomato.entity.Restaurant;
import org.ex.zomato.mapper.RestaurantMapper;
import org.ex.zomato.repository.RestaurantRepository;
import org.ex.zomato.requestDto.RestaurantRequest;
import org.ex.zomato.responseDto.RestaurantResponse;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.save(RestaurantMapper
                .mapToRestaurant(restaurantRequest, new Restaurant()));

        return RestaurantMapper.mapToRestaurantResponse(restaurant);
    }
}

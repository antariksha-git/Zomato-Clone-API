package org.ex.zomato.service;

import lombok.AllArgsConstructor;
import org.ex.zomato.entity.Restaurant;
import org.ex.zomato.mapper.RestaurantMapper;
import org.ex.zomato.repository.RestaurantRepository;
import org.ex.zomato.requestDto.RestaurantRequest;
import org.ex.zomato.responseDto.RestaurantResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantService {

    RestaurantRepository restaurantRepository;

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.save(RestaurantMapper
                .mapToRestaurant(restaurantRequest, new Restaurant()));

        return RestaurantMapper.mapToRestaurantResponse(restaurant);
    }
}

package org.ex.zomato.mapper;

import org.ex.zomato.entity.Restaurant;
import org.ex.zomato.responseDto.RestaurantResponse;
import org.ex.zomato.requestDto.RestaurantRequest;

public class RestaurantMapper {

    public static Restaurant mapToRestaurant(RestaurantRequest restaurantRequest, Restaurant restaurant) {
        restaurant.setDescription(restaurantRequest.getDescription());
        restaurant.setName(restaurantRequest.getName());
        restaurant.setEmail(restaurantRequest.getEmail());
        restaurant.setPhoneNumber(restaurantRequest.getPhoneNumber());
        restaurant.setDietTypes(restaurantRequest.getDietTypes());

        return restaurant;
    }

    public static RestaurantResponse mapToRestaurantResponse(Restaurant restaurant) {
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        restaurantResponse.setDescription(restaurant.getDescription());
        restaurantResponse.setName(restaurant.getName());
        restaurantResponse.setEmail(restaurant.getEmail());
        restaurantResponse.setPhoneNumber(restaurant.getPhoneNumber());
        restaurantResponse.setRestaurantId(restaurant.getRestaurantId());
        restaurantResponse.setDietTypes(restaurant.getDietTypes());

        return restaurantResponse;
    }
}

package org.ex.zomato.service;

import lombok.AllArgsConstructor;
import org.ex.zomato.entity.Address;
import org.ex.zomato.exception.RestaurantNotFoundByIdException;
import org.ex.zomato.mapper.AddressMapper;
import org.ex.zomato.repository.AddressRepository;
import org.ex.zomato.repository.RestaurantRepository;
import org.ex.zomato.requestDto.AddressRequest;
import org.ex.zomato.responseDto.AddressResponse;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressService {

    private AddressRepository repository;
    private RestaurantRepository restaurantRepository;

    public AddressResponse addAddressToRestaurant(AddressRequest addressRequest, String restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .map(r -> {
                    r.setAddress(AddressMapper.mapToAddress(addressRequest, new Address()));
                    restaurantRepository.save(r);
                    return AddressMapper.mapToAddressResponse(r.getAddress());
                })
                .orElseThrow(() -> new RestaurantNotFoundByIdException(restaurantId));
    }
}


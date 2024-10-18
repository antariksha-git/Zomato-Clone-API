package org.ex.zomato.controller;

import lombok.AllArgsConstructor;
import org.ex.zomato.requestDto.AddressRequest;
import org.ex.zomato.responseDto.AddressResponse;
import org.ex.zomato.service.AddressService;
import org.ex.zomato.service.RestaurantService;
import org.ex.zomato.util.AppResponseBuilder;
import org.ex.zomato.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("${zomato.base_url}")
@RestController
@AllArgsConstructor
public class AddressController {

    private AddressService addressService;
    private RestaurantService restaurantService;

    @PostMapping("/address/{restaurant_id}")
    public ResponseEntity<ResponseStructure<AddressResponse>> addAddressToRestaurant(
            @PathVariable("restaurant_id") String restaurantId,
            @RequestBody AddressRequest addressRequest) {

        AddressResponse addressResponse = addressService.addAddressToRestaurant(addressRequest, restaurantId);

        return AppResponseBuilder.create(HttpStatus.CREATED, "Added address successfully", addressResponse);
    }
}

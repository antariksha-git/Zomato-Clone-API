package org.ex.zomato.mapper;

import org.ex.zomato.entity.Address;
import org.ex.zomato.requestDto.AddressRequest;
import org.ex.zomato.responseDto.AddressResponse;

public class AddressMapper {
    public static Address mapToAddress(AddressRequest addressRequest, Address address) {
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setAddressLine1(addressRequest.getAddressLine1());
        address.setAddressLine2(addressRequest.getAddressLine2());
        address.setArea(addressRequest.getArea());
        address.setPinCode(addressRequest.getPinCode());
        address.setLandmark(addressRequest.getLandmark());
        address.setLongitude(addressRequest.getLongitude());
        address.setLatitude(addressRequest.getLatitude());

        return address;
    }

    public static AddressResponse mapToAddressResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAddressId(address.getAddressId());
        addressResponse.setCity(address.getCity());
        addressResponse.setState(address.getState());
        addressResponse.setAddressLine1(address.getAddressLine1());
        addressResponse.setAddressLine2(address.getAddressLine2());
        addressResponse.setArea(address.getArea());
        addressResponse.setPinCode(address.getPinCode());
        addressResponse.setLandmark(address.getLandmark());
        addressResponse.setLongitude(address.getLongitude());
        addressResponse.setLatitude(address.getLatitude());

        return addressResponse;
    }
}

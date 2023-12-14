package com.users.updater.mappers;

import com.users.randomuser.contract.LocationDto;
import com.users.usersdata.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements IMap<LocationDto.StreetDto, Address>{
    @Override
    public Address toEntity(LocationDto.StreetDto streetDto) {
        var address = new Address();
        address.setNumber(streetDto.getNumber());
        address.setStreet(streetDto.getName());
        return address;
    }
}

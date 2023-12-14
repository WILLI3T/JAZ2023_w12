package com.users.updater.mappers;

import com.users.randomuser.contract.LocationDto;
import com.users.usersdata.model.Location;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LocationsMapper implements IMap<LocationDto, List<Location>>{
    @Override
    public List<Location> toEntity(LocationDto locationDto) {
        var country = new Location();
        var state = new Location();
        var city = new Location();
        var postalCode = new Location();
        country.setName(locationDto.getCountry());
        country.setType("country");
        city.setName(locationDto.getCity());
        city.setType("city");
        state.setName(locationDto.getState());
        state.setType("state");
        postalCode.setName(locationDto.getPostcode());
        postalCode.setType("postalCode");

        return List.of(
                country, state, city, postalCode
        );
    }
}

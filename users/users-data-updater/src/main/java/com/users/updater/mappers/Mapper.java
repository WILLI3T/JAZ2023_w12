package com.users.updater.mappers;

import com.users.randomuser.contract.LocationDto;
import com.users.randomuser.contract.LoginDto;
import com.users.randomuser.contract.PictureDto;
import com.users.randomuser.contract.UserDto;
import com.users.usersdata.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper implements IMapper {

    private final IMap<UserDto, Person> person;
    private final IMap<LoginDto, User> user;
    private final IMap<PictureDto, Picture> picture;
    private final IMap<LocationDto, List<Location>> locations;
    private final IMap<LocationDto.StreetDto, Address> addresses;

    public Mapper(IMap<UserDto, Person> person,
                  IMap<LoginDto, User> user,
                  IMap<PictureDto, Picture> picture,
                  IMap<LocationDto, List<Location>> locations,
                  IMap<LocationDto.StreetDto, Address> addresses) {
        this.person = person;
        this.user = user;
        this.picture = picture;
        this.locations = locations;
        this.addresses = addresses;
    }

    @Override
    public IMap<UserDto, Person> person() {
        return person;
    }

    @Override
    public IMap<LoginDto, User> user() {
        return user;
    }

    @Override
    public IMap<PictureDto, Picture> picture() {
        return picture;
    }

    @Override
    public IMap<LocationDto, List<Location>> locations() {
        return locations;
    }

    @Override
    public IMap<LocationDto.StreetDto, Address> addresses() {
        return addresses;
    }
}

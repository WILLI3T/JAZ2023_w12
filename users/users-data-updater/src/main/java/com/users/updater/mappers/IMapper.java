package com.users.updater.mappers;

import com.users.randomuser.contract.LocationDto;
import com.users.randomuser.contract.LoginDto;
import com.users.randomuser.contract.PictureDto;
import com.users.randomuser.contract.UserDto;
import com.users.usersdata.model.*;

import java.util.List;

public interface IMapper {
    IMap<UserDto, Person> person();

    IMap<LoginDto, User> user();

    IMap<PictureDto, Picture> picture();

    IMap<LocationDto, List<Location>> locations();
    IMap<LocationDto.StreetDto, Address> addresses();
}

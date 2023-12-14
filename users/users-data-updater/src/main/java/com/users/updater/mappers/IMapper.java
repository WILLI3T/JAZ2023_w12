package com.users.updater.mappers;

import com.users.randomuser.contract.LoginDto;
import com.users.randomuser.contract.PictureDto;
import com.users.randomuser.contract.UserDto;
import com.users.usersdata.model.Person;
import com.users.usersdata.model.Picture;
import com.users.usersdata.model.User;

public interface IMapper {
    IMap<UserDto, Person> person();

    IMap<LoginDto, User> user();

    IMap<PictureDto, Picture> picture();
}

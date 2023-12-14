package com.users.updater.mappers;

import com.users.randomuser.contract.LoginDto;
import com.users.randomuser.contract.PictureDto;
import com.users.randomuser.contract.UserDto;
import com.users.usersdata.model.Person;
import com.users.usersdata.model.Picture;
import com.users.usersdata.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Mapper implements IMapper {

    private final IMap<UserDto, Person> person;
    private final IMap<LoginDto, User> user;
    private final IMap<PictureDto, Picture> picture;

    public Mapper(IMap<UserDto, Person> person, IMap<LoginDto, User> user, IMap<PictureDto, Picture> picture) {
        this.person = person;
        this.user = user;
        this.picture = picture;
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
}

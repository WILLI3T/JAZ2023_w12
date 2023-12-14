package com.users.updater.mappers;

import com.users.randomuser.contract.LoginDto;
import com.users.usersdata.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IMap<LoginDto, User> {
    @Override
    public User toEntity(LoginDto loginDto) {
        var user = new User();
        user.setMd5(loginDto.getMd5());
        user.setSalt(loginDto.getSalt());
        user.setSha1(loginDto.getSha1());
        user.setPassword(loginDto.getPassword());
        user.setUuid(loginDto.getUuid());
        user.setUsername(loginDto.getUsername());
        return user;
    }
}

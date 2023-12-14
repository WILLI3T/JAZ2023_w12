package com.users.updater.mappers;

import com.users.randomuser.contract.LoginDto;
import com.users.randomuser.contract.UserDto;
import com.users.usersdata.model.Person;
import com.users.usersdata.model.User;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements IMap<UserDto, Person> {
    IMap<LoginDto, User> userMapper;

    public PersonMapper(IMap<LoginDto, User> userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Person toEntity(UserDto personDto) {
        var person = new Person();
        person.setEmail(personDto.getEmail());
        person.setFirstname(personDto.getName().getFirst());
        person.setLastname(personDto.getName().getLast());
        person.setPhone(personDto.getPhone());
        person.setGender(personDto.getGender());
        person.setAge(personDto.getDob().getAge());
        person.setDateOfBirth(personDto.getDob().getDate());
        /**
         * zinwestygować
         */
        person.setUser(userMapper.toEntity(personDto.getLogin()));

        return person;
    }
}

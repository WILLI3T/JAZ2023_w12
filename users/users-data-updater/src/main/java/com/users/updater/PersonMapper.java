package com.users.updater;

import com.users.randomuser.contract.UserDto;
import com.users.usersdata.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements IMap<UserDto, Person>{
    @Override
    public Person map(UserDto personDto) {
        var person = new Person();
        person.setEmail(personDto.getEmail());
        person.setFirstname(personDto.getName().getFirst());
        person.setLastname(personDto.getName().getLast());
        person.setPhone(personDto.getPhone());
        person.setGender(personDto.getGender());
        return person;
    }
}

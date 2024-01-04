package com.users.webapi.services;

import com.users.usersdata.model.Person;
import com.users.usersdata.repositories.IRepositoriesCatalog;
import com.users.webapi.contract.PersonDto;
import com.users.webapi.contract.PictureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService implements IPersonService {

    private final IRepositoriesCatalog db;
    @Override
    public List<PersonDto> getByPage(int size, int page) {
        return db.getPeople().findAll(PageRequest.of(page, size)).stream().map(p-> mapFromPerson(p))
                .toList();
    }

    @Override
    public PersonDto getById(long id) {
        var p = db.getPeople().findById(id).orElse(null);
        if(p==null) return null;
        return mapFromPerson(p);
    }





    @Override
    public long save(PersonDto personDto) {
        Person person = getPersonFromDto(personDto);
        var p =db.getPeople().save(person);
        return p.getId();
    }


    @Override
    public PersonDto delete(long id){
        var person = db.getPeople().findById(id).orElse(null);
        if(person==null) return null;
        db.getPeople().delete(person);
        return mapFromPerson(person);
    }

    @Override
    public PersonDto update(long id, PersonDto personDto) {
        var person = db.getPeople().findById(id).orElse(null);
        if(person==null) return null;
        db.getPeople().save(getPersonFromDto(personDto, person));
        return personDto;
    }


    private static Person getPersonFromDto(PersonDto personDto) {

        return getPersonFromDto(personDto, new Person());
    }
    private static Person getPersonFromDto(PersonDto personDto, Person person) {
        person.setDateOfBirth(personDto.getDateOfBirth());
        person.setGender(personDto.getGender());
        person.setPhone(personDto.getPhone());
        person.setFirstname(personDto.getFirstname());
        person.setLastname(personDto.getLastname());
        person.setAge(personDto.getAge());
        return person;
    }

    private static PersonDto mapFromPerson(Person p) {
        return new PersonDto()
                .setGender(p.getGender())
                .setPhone(p.getPhone())
                .setEmail(p.getEmail())
                .setAge(p.getAge())
                .setId(p.getId())
                .setFirstname(p.getFirstname())
                .setLastname(p.getLastname())
                .setDateOfBirth(p.getDateOfBirth());
    }

    @Override
    public PictureDto getPictures(long personId) {
        var person = db.getPeople().findById(personId).orElse(null);
        if(person==null) return null;
        var picture = person.getPicture();
        if(picture==null) return null;

        return new PictureDto().setId(picture.getId())
                .setLarge(picture.getLarge())
                .setMedium(picture.getMedium())
                .setThumbnail(picture.getThumbnail());
    }
}

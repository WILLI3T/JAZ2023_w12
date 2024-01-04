package com.users.webapi.services;

import com.users.webapi.contract.PersonDto;
import com.users.webapi.contract.PictureDto;

import java.util.List;

public interface IPersonService {
    List<PersonDto> getByPage(int size, int page);

    PersonDto getById(long id);

    long save(PersonDto personDto);

    PersonDto delete(long id);

    PersonDto update(long id, PersonDto personDto);

    PictureDto getPictures(long personId);
}

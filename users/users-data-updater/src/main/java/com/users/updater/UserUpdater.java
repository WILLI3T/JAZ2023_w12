package com.users.updater;

import com.users.randomuser.apiclient.IRandomUsersApiClient;
import com.users.randomuser.contract.UserDto;
import com.users.updater.mappers.IMapper;
import com.users.usersdata.repositories.IRepositoriesCatalog;
import org.springframework.stereotype.Service;

@Service
public class UserUpdater implements IUpdate {
    final IMapper map;
    final IRandomUsersApiClient client;
    final IRepositoriesCatalog database;

    public UserUpdater(IRandomUsersApiClient client, IMapper map, IRepositoriesCatalog database) {
        this.map = map;
        this.client = client;
        this.database = database;
    }

    @Override
    public void update(int size){
        client.getRandomUsers(size)
                .getResults()
                .forEach(this::savePerson);
    }

    void savePerson(UserDto personDto){
        var user = map.user().toEntity(personDto.getLogin());
        var person = map.person().toEntity(personDto);
        database.getUsers().save(user);
        person.setUser(user);
        database.getPeople().save(person);
        var picture = map.picture().toEntity(personDto.getPicture());
        picture.setPerson(person);
        database.getPictures().save(picture);

    }
}

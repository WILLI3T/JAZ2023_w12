package com.users.updater;

import com.users.randomuser.apiclient.IRandomUsersApiClient;
import com.users.randomuser.contract.LocationDto;
import com.users.randomuser.contract.UserDto;
import com.users.updater.mappers.*;
import com.users.usersdata.model.Location;
import com.users.usersdata.model.Person;
import com.users.usersdata.repositories.IRepositoriesCatalog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserUpdater implements IUpdate {

    static void sampleMethod(){
        new Mapper(new PersonMapper(), new UserMapper(),new PictureMapper(), new LocationsMapper(), new AddressMapper());
    }

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

        saveLocations(personDto.getLocation(), person);

    }

    private void saveLocations(LocationDto location, Person person) {
        var locations = map.locations().toEntity(location);
        var locationsFromDb = new ArrayList<Location>();
        for(var loc : locations){
            var locFromDb = database.getLocations().findFirstByNameAndType(loc.getName(), loc.getType())
                    .orElse(null);
            if(locFromDb==null){
                database.getLocations().save(loc);
                locFromDb = loc;
            }
            locationsFromDb.add(locFromDb);
        }
        var country = locationsFromDb.stream().filter(x->x.getType().equals("country")).findFirst().orElse(null);
        var state = locationsFromDb.stream().filter(x->x.getType().equals("state")).findFirst().orElse(null);
        var city = locationsFromDb.stream().filter(x->x.getType().equals("city")).findFirst().orElse(null);
        var postalCode = locationsFromDb.stream().filter(x->x.getType().equals("postalCode")).findFirst().orElse(null);
        state.setParent(country);
        database.getLocations().save(state);
        city.setParent(state);
        database.getLocations().save(city);
        postalCode.setParent(city);
        database.getLocations().save(postalCode);

        var address = map.addresses().toEntity(location.getStreet());
        address.setCity(postalCode);
        address.setPerson(person);
        database.getAddresses().save(address);
    }
}

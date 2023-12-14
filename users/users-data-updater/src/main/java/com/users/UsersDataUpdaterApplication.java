package com.users;

import com.users.randomuser.apiclient.IRandomUsersApiClient;
import com.users.randomuser.contract.LoginDto;
import com.users.randomuser.contract.PictureDto;
import com.users.randomuser.contract.UserDto;
import com.users.updater.mappers.IMap;
import com.users.usersdata.model.Person;
import com.users.usersdata.model.Picture;
import com.users.usersdata.model.User;
import com.users.usersdata.repositories.IRepositoriesCatalog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
public class UsersDataUpdaterApplication implements CommandLineRunner {

//
//    final IMap<UserDto, Person> mapper;
//    final IMap<LoginDto, User> userMapper;
//    final IMap<PictureDto, Picture> pictureMapper;
//    final IRandomUsersApiClient client;
//
//    final IRepositoriesCatalog database;
//    public UsersDataUpdaterApplication(IMap<UserDto, Person> mapper, IMap<LoginDto, User> userMapper, IMap<PictureDto, Picture> pictureMapper, IRandomUsersApiClient client, IRepositoriesCatalog database) {
//        this.database = database;
//
//        this.mapper = mapper;
//        this.userMapper = userMapper;
//        this.pictureMapper = pictureMapper;
//        this.client = client;
//    }

    public static void main(String[] args) {
        SpringApplication.run(UsersDataUpdaterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


//        var ageAverageFrom  = getAgeAverage(35);
//        var pplWIthAge = getPeopleWithAge();
//
//        var person = database.getPeople().findByAgeEquals(71);
//        client.getRandomUsers(500)
//                .getResults()
//                .stream()
////                .map(mapper::map)
////                .forEach(p->{
////                    /**
////                     * tutaj wywali błąd !!
////                     */
////                    repo.save(p);
////                });
//                .forEach(this::savePerson);


    }


//    void savePerson(UserDto personDto){
//        var user = userMapper.toEntity(personDto.getLogin());
//        var person = mapper.toEntity(personDto);
//
//        database.getUsers().save(user);
//        person.setUser(user);
//        database.getPeople().save(person);
//        var picture = pictureMapper.toEntity(personDto.getPicture());
//        database.getPictures().save(picture);
//    }

//    List<Person> getPeopleWithAge(){
//
//        /**
//         * spróbujmy za pomocą konwencji nazewniczej, ale troche inaczej
//         */
//        //return repo.findAllByAgeIsGreaterThan(20);
//        /**
//         * za pomocą adnotacji Query
//         */
//        var results = database.getPeople().findAllWhereAgeIsGreater(50);
//        return database.getPeople().findAllWhereAgeExists();
//    }
//
//    Double getAgeAverage(int ageFrom){
//        return database.getPeople().getAgeAverage(ageFrom).getAverage();
//    }
}

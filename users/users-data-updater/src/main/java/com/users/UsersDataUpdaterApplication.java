package com.users;

import com.users.randomuser.apiclient.IRandomUsersApiClient;
import com.users.randomuser.contract.LoginDto;
import com.users.randomuser.contract.UserDto;
import com.users.updater.IMap;
import com.users.usersdata.model.Person;
import com.users.usersdata.model.User;
import com.users.usersdata.repositories.PersonRepository;
import com.users.usersdata.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
public class UsersDataUpdaterApplication implements CommandLineRunner {

    final PersonRepository repo;
    final UserRepository userRepo;
    final IMap<UserDto, Person> mapper;
    final IMap<LoginDto, User> userMapper;
    final IRandomUsersApiClient client;
    public UsersDataUpdaterApplication(PersonRepository repo, UserRepository userRepo, IMap<UserDto, Person> mapper, IMap<LoginDto, User> userMapper, IRandomUsersApiClient client) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.userMapper = userMapper;
        this.client = client;
    }

    public static void main(String[] args) {
        SpringApplication.run(UsersDataUpdaterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        var ageAverageFrom  = getAgeAverage(35);
        var pplWIthAge = getPeopleWithAge();

        var person = repo.findByAgeEquals(71);
        client.getRandomUsers(5)
                .getResults()
                .stream()
//                .map(mapper::map)
//                .forEach(p->{
//                    /**
//                     * tutaj wywali błąd !!
//                     */
//                    repo.save(p);
//                });
                .forEach(this::savePerson);


    }


    void savePerson(UserDto personDto){
        var user = userMapper.map(personDto.getLogin());
        var person = mapper.map(personDto);

        userRepo.save(user);
        person.setUser(user);
        repo.save(person);

    }

    List<Person> getPeopleWithAge(){

        /**
         * spróbujmy za pomocą konwencji nazewniczej, ale troche inaczej
         */
        //return repo.findAllByAgeIsGreaterThan(20);
        /**
         * za pomocą adnotacji Query
         */
        var results = repo.findAllWhereAgeIsGreater(50);
        return repo.findAllWhereAgeExists();
    }

    Double getAgeAverage(int ageFrom){
        return repo.getAgeAverage(ageFrom).getAverage();
    }
}

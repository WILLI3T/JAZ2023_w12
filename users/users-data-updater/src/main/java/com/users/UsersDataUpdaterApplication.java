package com.users;

import com.users.randomuser.apiclient.IRandomUsersApiClient;
import com.users.randomuser.contract.UserDto;
import com.users.updater.IMap;
import com.users.usersdata.model.Person;
import com.users.usersdata.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class UsersDataUpdaterApplication implements CommandLineRunner {

    final PersonRepository repo;
    final IMap<UserDto, Person> mapper;
    final IRandomUsersApiClient client;
    public UsersDataUpdaterApplication(PersonRepository repo, IMap<UserDto, Person> mapper, IRandomUsersApiClient client) {
        this.repo = repo;
        this.mapper = mapper;
        this.client = client;
    }

    public static void main(String[] args) {
        SpringApplication.run(UsersDataUpdaterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        client.getRandomUsers(5000)
                .getResults()
                .stream()
                .map(mapper::map)
                .forEach(repo::save);
    }
}

package com.users.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.users")
//@EnableJpaRepositories
public class UsersWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersWebApiApplication.class, args);
    }

}

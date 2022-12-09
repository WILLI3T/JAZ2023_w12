package com.users.usersdata.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Person person;

    private String username;
    private String password;
    private String uuid;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;


}

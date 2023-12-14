package com.users.usersdata.repositories;


import org.springframework.stereotype.Repository;

@Repository
public class RepositoriesCatalog implements IRepositoriesCatalog {
    private final PictureRepository pictures;
    private final PersonRepository people;
    private final UserRepository users;
    private final LocationRepository locations;
    private final AddressRepository addresses;

    public RepositoriesCatalog(PictureRepository pictures, PersonRepository people, UserRepository users, LocationRepository locations, AddressRepository addresses) {
        this.pictures = pictures;
        this.people = people;
        this.users = users;
        this.locations = locations;
        this.addresses = addresses;
    }

    @Override
    public PictureRepository getPictures() {
        return pictures;
    }

    @Override
    public PersonRepository getPeople() {
        return people;
    }

    @Override
    public UserRepository getUsers() {
        return users;
    }

    @Override
    public LocationRepository getLocations() {
        return locations;
    }

    @Override
    public AddressRepository getAddresses() {
        return addresses;
    }
}

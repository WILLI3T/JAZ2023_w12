package com.users.usersdata.repositories;

public interface IRepositoriesCatalog {
    PictureRepository getPictures();

    PersonRepository getPeople();

    UserRepository getUsers();
    LocationRepository getLocations();

    AddressRepository getAddresses();
}

package com.users.usersdata.repositories;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Getter
@RequiredArgsConstructor
public class RepositoriesCatalog implements IRepositoriesCatalog {
    private final PictureRepository pictures;
    private final PersonRepository people;
    private final UserRepository users;
    private final LocationRepository locations;
    private final AddressRepository addresses;
}

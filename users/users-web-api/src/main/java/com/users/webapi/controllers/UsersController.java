package com.users.webapi.controllers;

import com.users.usersdata.model.Address;
import com.users.usersdata.model.User;
import com.users.usersdata.repositories.IRepositoriesCatalog;
import com.users.usersdata.repositories.UserRepository;
import com.users.webapi.contract.AddressDto;
import com.users.webapi.contract.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final IRepositoriesCatalog db;

    @GetMapping
    public ResponseEntity getSample(){
        var dto = new AddressDto();
        var entity = db.getAddresses().findById(1030L).orElse(null);
//        dto.setNumber(entity.getNumber());
//        dto.setStreet(entity.getStreet());
        //...

        var user = new UserDto(1, "", "", "","","","","");

        var userFromBuilder = UserDto
                .builder()
                .md5("asdd")
                .id(4)
                .password("password")
                .build();

        var usersFromDb = db.getUsers().findAll().stream()
                .map(x->UserDto
                        .builder()
                        .password(x.getPassword())
                        .username(x.getUsername())
                        .build())
                .toList();

        var addressesFromDb = db.getAddresses().findAll().stream()
                .map(x->new AddressDto()
                        .number(x.getNumber())
                        .street(x.getStreet())
                        )
                .toList();

        log.info("pobralem "+ usersFromDb.size());
        return ResponseEntity.ok(usersFromDb);
    }

    private static URI getLocationUri(long id) {

        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(id+"")
                .buildAndExpand(1)
                .toUri();
    }


}

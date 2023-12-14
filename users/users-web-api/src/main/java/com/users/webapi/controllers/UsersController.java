package com.users.webapi.controllers;

import com.users.usersdata.repositories.IRepositoriesCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private final IRepositoriesCatalog database;
}

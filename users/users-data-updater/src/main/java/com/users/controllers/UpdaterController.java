package com.users.controllers;

import com.users.updater.IUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("updater")
public class UpdaterController {

    private final IUpdate updater;

    public UpdaterController(IUpdate updater) {
        this.updater = updater;
    }

    @GetMapping("update")
    public ResponseEntity update(@RequestParam int size){
        new Thread(()->updater.update(size)).start();
        return ResponseEntity.ok("Update Started at "+ LocalDateTime.now());
    }

}

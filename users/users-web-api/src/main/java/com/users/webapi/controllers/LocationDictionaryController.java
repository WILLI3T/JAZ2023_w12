package com.users.webapi.controllers;

import com.users.webapi.contract.LocationDto;
import com.users.webapi.services.CacheService;
import com.users.webapi.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("api/v1/locations")
@RequiredArgsConstructor
public class LocationDictionaryController {

    private final CacheService cacheService;
    private final LocationService locationService;
    @GetMapping
    public ResponseEntity<List<LocationDto>> getAll(@RequestParam(required = false) String type){
        if(type==null)
            return ResponseEntity.ok(locationService.getAll());
        return ResponseEntity.ok(locationService.getByType(type));
    }

    @GetMapping("{parentId}")
    public ResponseEntity<List<LocationDto>> getChildren(@PathVariable int parentId){
        return ResponseEntity.ok(locationService.getChildren(parentId));
    }

    @GetMapping("clearCache")
    public ResponseEntity clearCache(){
        cacheService.clearCache();
        return ResponseEntity.ok().build();
    }

}

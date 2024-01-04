package com.users.webapi.services;

import com.users.usersdata.repositories.RepositoriesCatalog;
import com.users.webapi.contract.LocationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final RepositoriesCatalog db;

    @Cacheable("locationCache")
    public List<LocationDto> getAll() {
        return db.getLocations()
                .findAll()
                .stream()
                .map(x->new LocationDto(x.getId(), x.getName(), x.getType()))
                .toList();
    }
    //@Cacheable(value = "locationCache", key = "#type")
    public List<LocationDto> getByType(String type){
        return db.getLocations()
                .findAllByType(type)
                .stream()
                .map(x->new LocationDto(x.getId(), x.getName(), x.getType()))
                .toList();
    }

    public List<LocationDto> getChildren(int parentId) {
        return db.getLocations()
                .findByParentId(parentId)
                .stream()
                .map(x->new LocationDto(x.getId(), x.getName(), x.getType()))
                .toList();
    }
}

package com.users.usersdata.repositories;

import com.users.usersdata.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Optional<Location> findFirstByNameAndType(String name, String type);
}

package com.users.usersdata.repositories;

import com.users.usersdata.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Optional<Location> findFirstByNameAndType(String name, String type);

    List<Location> findAllByType(String type);

    @Query(value = "select x from Location x where x.parent.id = :parentId")
    List<Location> findByParentId(@Param("parentId") int parentId);
}

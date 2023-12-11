package com.users.usersdata.repositories;

import com.users.usersdata.model.Person;
import com.users.usersdata.model.projections.PersonAverageProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Konwencja nazewnicza
     * @param ageFrom
     * @return
     */
    List<Person> findAllByAgeIsGreaterThan(int ageFrom);
     List<Person> findByAgeEquals(int age);

    /**
     * Wykorzystanie adnotacji Query
     * @return
     */
    @Query(value = "SELECT p FROM Person p where p.age is null")
    List<Person> findAllWhereAgeExists();
    @Query(value = "SELECT p FROM Person p where p.age >= :age")
    List<Person> findAllWhereAgeIsGreater(@Param("age") int age);

    /**
     * Wykorzystanie Projekcji
     */
    @Query(value = "SELECT new com.users.usersdata.model.projections.PersonAverageProjection(AVG(p.age)) FROM Person p where p.age>= :age")
    PersonAverageProjection getAgeAverage(@Param("age") int ageFrom);
}

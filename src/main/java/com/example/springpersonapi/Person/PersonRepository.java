package com.example.springpersonapi.Person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    List<Person> findAllByOrderByFirstName();

    List<Person> findAllByOrderByBirthday();
}

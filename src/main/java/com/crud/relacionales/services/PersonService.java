package com.crud.relacionales.services;

import com.crud.relacionales.models.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {
    public List<Person> findAllPerson();
    public Person createPerson(Person person);
    public Person updatePerson(Person person);
    public Person findOnePerson(Long id);
    public void deletePerson(Long id);
}

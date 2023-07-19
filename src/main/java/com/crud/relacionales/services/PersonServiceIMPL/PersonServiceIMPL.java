package com.crud.relacionales.services.PersonServiceIMPL;

import com.crud.relacionales.models.Person;
import com.crud.relacionales.repository.PersonRepository;
import com.crud.relacionales.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceIMPL implements PersonService {

    @Autowired
    private PersonRepository personRepo;

    /**
     * Method for find all persons
     * @return List of all persons
     */
    @Override
    public List<Person> findAllPerson() {
        return (List<Person>) this.personRepo.findAll();
    }

    /**
     * Method for create a person
     * @return A new Person
     */
    @Override
    public Person createPerson(Person person) {
        person.setDocument(person.getDocument());
        return this.personRepo.save(person);
    }

    /**
     * Method for update a person
     * @return A Person updated
     */
    @Override
    public Person updatePerson(Person person) {
        return this.personRepo.save(person);
    }

    /**
     * Method for find one person by id
     * @return A Person found
     */
    @Override
    public Person findOnePerson(Long id) {
        return this.personRepo.findById(id).get();
    }

    /**
     * Method for delete a person by id
     * @return void
     */
    @Override
    public void deletePerson(Long id) {
        this.personRepo.deleteById(id);
    }
}

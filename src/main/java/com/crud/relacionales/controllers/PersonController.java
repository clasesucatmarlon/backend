package com.crud.relacionales.controllers;

import com.crud.relacionales.models.Person;
import com.crud.relacionales.services.PersonServiceIMPL.PersonServiceIMPL;
import com.crud.relacionales.validators.ValidateEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@RequestMapping("crudrelational")
public class PersonController {
    @Autowired
    private PersonServiceIMPL psIMPL;

    @GetMapping
    @RequestMapping(value = "findallpersons", method = RequestMethod.GET)
    public ResponseEntity<?> FindAllPersons() {
        List<Person> listPersons = this.psIMPL.findAllPerson();
        return ResponseEntity.ok(listPersons);
    }

    @PostMapping
    @RequestMapping(value = "createperson", method = RequestMethod.POST)
    public ResponseEntity<?> CreatePerson(@RequestBody Person person) {
        ValidateEmail validateEmail = new ValidateEmail();
        Boolean sucessEmail = validateEmail.IsValidEmail(person.getEmail());

        if (sucessEmail) {
            Person personCreated = this.psIMPL.createPerson(person);
            return ResponseEntity.status(HttpStatus.CREATED).body(personCreated);
        } else {
            var error = "Error: " + 206 + " Partial Content";
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).build();
        }
    }

    @PutMapping
    @RequestMapping(value = "updateperson", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdatePerson(@RequestBody Person person) {
        Person personUpdated = this.psIMPL.updatePerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personUpdated);
    }


    @GetMapping
    @RequestMapping(value = "findoneperson/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> FindOnePerson(@PathVariable Long id) {
        Person personFound = this.psIMPL.findOnePerson(id);
        return ResponseEntity.ok(personFound);
    }

    @DeleteMapping
    @RequestMapping(value = "deleteperson/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> DeletePerson(@PathVariable Long id) {
        this.psIMPL.deletePerson(id);
        return ResponseEntity.ok().build();
    }

}

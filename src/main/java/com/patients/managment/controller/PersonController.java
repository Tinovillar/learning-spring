package com.patients.managment.controller;

import com.patients.managment.model.Person;
import com.patients.managment.model.Rol;
import com.patients.managment.repository.PersonRepository;
import com.patients.managment.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/person")
@CrossOrigin // Only for local communication with the database and test
@RequiredArgsConstructor
public class PersonController {
    @Autowired
    private final PersonService personService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter/rol/{rol}")
    public List<Person> findByRol(@PathVariable Rol rol) {
        return personService.findAllByRol(rol);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("")
    public Optional<Person> updatePerson(@RequestBody Person person, Long id) {
        return personService.updatePerson(person, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Optional<Person> deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }
}

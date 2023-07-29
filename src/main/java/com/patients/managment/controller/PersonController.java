package com.patients.managment.controller;

import com.patients.managment.dto.PersonRequest;
import com.patients.managment.dto.PersonResponse;
import com.patients.managment.model.Role;
import com.patients.managment.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@CrossOrigin // Only for local communication with the database and test
@RequiredArgsConstructor
public class PersonController {
    @Autowired
    private final PersonService personService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<PersonResponse> findAll() {
        return personService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter/role/{role}")
    public List<PersonResponse> findByRol(@PathVariable Role role) {
        return personService.findAllByRol(role);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PersonResponse findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void addPerson(@RequestBody PersonRequest personRequest) {
        personService.addPerson(personRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("")
    public PersonResponse updatePerson(@RequestBody PersonRequest personRequest, Long id) {
        return personService.updatePerson(personRequest, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public PersonResponse deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }
}

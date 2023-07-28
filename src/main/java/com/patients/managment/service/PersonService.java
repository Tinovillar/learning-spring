package com.patients.managment.service;

import com.patients.managment.model.Person;
import com.patients.managment.model.Rol;
import com.patients.managment.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findAllByRol(Rol rol) {
        return personRepository.findAllByRol(rol);
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public Optional<Person> updatePerson(Person person, Long id) {
        if(!personRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        Optional<Person> lastPerson = personRepository.findById(id);
        personRepository.save(person);
        return lastPerson;
    }

    public Optional<Person> deletePerson(Long id) {
        Optional<Person> deleted = personRepository.findById(id);
        personRepository.deleteById(id);
        return deleted;
    }
}

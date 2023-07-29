package com.patients.managment.service;
import com.patients.managment.dto.PersonRequest;
import com.patients.managment.dto.PersonResponse;
import com.patients.managment.model.Person;
import com.patients.managment.model.Role;
import com.patients.managment.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<PersonResponse> findAll() {
        return personRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public List<PersonResponse> findAllByRol(Role role) {
        return personRepository.findAllByRol(role)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public PersonResponse findById(Long id) {
        Optional<Person> toReturn = personRepository.findById(id);
        return toReturn.map(this::convertToResponse).orElse(null);
    }

    public void addPerson(PersonRequest personRequest) {
        Person toAdd = new Person();
        BeanUtils.copyProperties(personRequest, toAdd);
        personRepository.save(toAdd);
    }

    public PersonResponse updatePerson(PersonRequest personRequest, Long id) {
        if(!personRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        Person updated = new Person();
        BeanUtils.copyProperties(personRequest, updated);
        Optional<Person> lastPerson = personRepository.findById(id);
        personRepository.save(updated);
        return lastPerson.map(this::convertToResponse).orElse(null);
    }

    public PersonResponse deletePerson(Long id) {
        Optional<Person> deleted = personRepository.findById(id);
        personRepository.deleteById(id);
        return deleted.map(this::convertToResponse).orElse(null);
    }

    private PersonResponse convertToResponse(Person person) {
        PersonResponse personResponse = new PersonResponse();
        BeanUtils.copyProperties(person, personResponse);
        return personResponse;
    }
}

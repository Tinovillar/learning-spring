package com.patients.managment.repository;

import com.patients.managment.model.Person;
import com.patients.managment.model.Role;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

// public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {} this one can handle pages requests, like give me only the first 20 items etc etc
// public interface PersonRepository extends CrudRepository<Person, Long> {} this one returns Iterables instead of lists
public interface PersonRepository extends ListCrudRepository<Person, Long> {
    // Queries made by my own, following the docs
    public List<Person> findAllByRol(Role role);
}

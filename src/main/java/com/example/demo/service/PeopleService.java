package com.example.demo.service;

import com.example.demo.model.Person;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeopleService {

    Person person = new Person(1L, "John");

    public List<Person> getPeople() {
        return List.of(person, new Person(2L, "Tom"));
    }

    public Person getPersonById(Long personId) {
        if (personId == 1) {
            return new Person(1L, "John");
        } else {
            return person;
        }
    }
}

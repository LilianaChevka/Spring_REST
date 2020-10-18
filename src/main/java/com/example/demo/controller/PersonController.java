package com.example.demo.controller;

import com.example.demo.GetPersonRequest;
import com.example.demo.model.Person;
import com.example.demo.service.CreatePersonRequest;
import com.example.demo.service.PeopleService;
import com.example.demo.service.UpdatePersonRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PersonController {

    final PeopleService peopleService;

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getPeople() {
        return ResponseEntity.ok(peopleService.getPeople());
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable Long personId) {
        return ResponseEntity.ok(peopleService.getPersonById(personId));
    }

    @GetMapping("/person/query")
    public ResponseEntity<Person> getPersonByRequestParam(@Validated @ModelAttribute GetPersonRequest request) {
        System.out.println(request.getName());
        return ResponseEntity.ok(peopleService.getPersonById(request.getPersonId()));

    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody CreatePersonRequest request) {
        Person person = new Person();
        person.setId(3L);
        person.setName(request.getName());
        System.out.println(person);
        return ResponseEntity.ok(person);

    }

    @PutMapping("/people")
    public ResponseEntity<Person> updatePerson(@RequestBody UpdatePersonRequest request) {
        Person person = new Person();
        person.setId(5L);
        person.setName("Brian");
        System.out.println(person);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/person/{personId}")
    public void deletePerson(@PathVariable Long personId) {
        System.out.println(personId);
    }

}

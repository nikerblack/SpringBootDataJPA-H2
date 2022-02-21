package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

//mark class as Controller  
@RestController
public class PersonController {
  
	@Autowired
	PersonService personService;

   
	@GetMapping("/persons")
	private List<Person> getAllPerson() {
		return personService.getAllPerson();
	}

  
	@GetMapping("/person/{personid}")
	private Person getPerson(@PathVariable("personid") int personId) {
		return personService.getPersonById(personId);
	}

  
	@DeleteMapping("/person/{personid}")
	private void deletePerson(@PathVariable("personid") int personId) {
		personService.delete(personId);
	}

  
	@PostMapping("/persons")
	private int savePerson(@RequestBody Person person) {
		personService.saveOrUpdate(person);
		return person.getId();
	}

   
	@PutMapping("/person")
	private Person update(@RequestBody Person person) {
		personService.saveOrUpdate(person);
		return person;
	}
}
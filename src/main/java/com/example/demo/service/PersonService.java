package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;

	public List<Person> getAllPerson() {
		List<Person> personL = new ArrayList<Person>();
		personRepository.findAll().forEach(person -> personL.add(person));
		return personL;
	}

	public Person getPersonById(int id) {
		return personRepository.findById(id).get();
	}

	public void saveOrUpdate(Person person) {
		personRepository.save(person);
	}

	public void delete(int id) {
		personRepository.deleteById(id);
	}

	public void update(Person person, int personId) {
		personRepository.save(person);
	}
}

package pl.piomin.services.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.piomin.services.person.model.Person;
import pl.piomin.services.person.repository.PersonRepository;

@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonRepository repository;
	
	@GetMapping("/{id}")
	public Person findPersonById(@PathVariable("id") Integer id) {
		return repository.findById(id);
	}
}

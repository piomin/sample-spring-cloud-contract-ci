package pl.piomin.services.person.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.services.person.model.Person;
import pl.piomin.services.person.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	PersonRepository repository;
	
	@GetMapping("/{id}")
	public Person findPersonById(@PathVariable("id") Integer id) {
		LOGGER.info("Request: findPersonById->{}", id);
		return repository.findById(id);
	}
	
}

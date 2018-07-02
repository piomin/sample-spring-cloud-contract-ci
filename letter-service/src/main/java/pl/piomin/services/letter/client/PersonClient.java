package pl.piomin.services.letter.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.piomin.services.letter.model.Person;

@FeignClient("person-service")
public interface PersonClient {

	@GetMapping("/persons/{id}")
	Person findPersonById(@PathVariable("id") Integer id);
	
}

package pl.piomin.services.bank.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.piomin.services.bank.model.Person;

@FeignClient("person-service")
public interface PersonClient {

	@GetMapping("/persons/{id}")
	Person findPersonById(@PathVariable("id") Integer id);
	
}

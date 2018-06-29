package pl.piomin.services.person;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import pl.piomin.services.person.model.Gender;
import pl.piomin.services.person.model.PersonBuilder;
import pl.piomin.services.person.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public abstract class BasePersonContractTest {

	@Autowired
	WebApplicationContext context;
	@MockBean
	PersonRepository repository;
	
	@Before
	public void setup() {
		RestAssuredMockMvc.webAppContextSetup(this.context);
		PersonBuilder builder = new PersonBuilder()
			.withId(1)
			.withFirstName("Piotr")
			.withLastName("Minkowski")
			.withBirthDate(new Date())
			.withAccountNo("1234567890")
			.withGender(Gender.MALE)
			.withPhoneNo("500070935")
			.withCity("Warsaw")
			.withCountry("Poland")
			.withHouseNo(200)
			.withStreet("Al. Jerozolimskie")
			.withEmail("piotr.minkowski@gmail.com")
			.withPostalCode("02-660");
		when(repository.findById(1)).thenReturn(builder.build());
	}
	
}

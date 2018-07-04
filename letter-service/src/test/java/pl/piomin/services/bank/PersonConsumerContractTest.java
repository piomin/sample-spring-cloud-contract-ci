package pl.piomin.services.bank;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import pl.piomin.services.letter.LetterApplication;
import pl.piomin.services.letter.client.PersonClient;
import pl.piomin.services.letter.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE, classes = {LetterApplication.class})
@AutoConfigureStubRunner(ids = {"pl.piomin.services:person-service:+:stubs:8090"}, consumerName = "letter-consumer",  stubsPerConsumer = true, stubsMode = StubsMode.REMOTE, repositoryRoot = "http://192.168.99.100:8081/artifactory/libs-snapshot-local")
@DirtiesContext
public class PersonConsumerContractTest {

	@Autowired
	private PersonClient personClient;
	
	@Test
	public void verifyPerson() {
		Person p = personClient.findPersonById(1);
		Assert.assertNotNull(p);
		Assert.assertEquals(1, p.getId().intValue());
		Assert.assertNotNull(p.getFirstName());
		Assert.assertNotNull(p.getLastName());
		Assert.assertNotNull(p.getAddress());
		Assert.assertNotNull(p.getAddress().getCity());
		Assert.assertNotNull(p.getAddress().getCountry());
		Assert.assertNotNull(p.getAddress().getPostalCode());
		Assert.assertNotNull(p.getAddress().getStreet());
		Assert.assertNotEquals(0, p.getAddress().getHouseNo());
	}
	
}

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

import pl.piomin.services.bank.client.PersonClient;
import pl.piomin.services.bank.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"pl.piomin.services:person-service:+:stubs:8090"}, consumerName = "bank-consumer",  stubsPerConsumer = true, stubsMode = StubsMode.REMOTE, repositoryRoot = "http://192.168.99.100:8081/artifactory/libs-snapshot-local")
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
		Assert.assertNotNull(p.getAccountNumber());
		Assert.assertNotNull(p.getBirthDate());
		Assert.assertNotNull(p.getGender());
	}
	
}

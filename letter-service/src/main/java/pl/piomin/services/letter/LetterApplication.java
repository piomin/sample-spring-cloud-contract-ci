package pl.piomin.services.letter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LetterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetterApplication.class, args);
	}
	
}

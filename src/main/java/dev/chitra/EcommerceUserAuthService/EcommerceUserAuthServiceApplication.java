package dev.chitra.EcommerceUserAuthService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // im excluding this for using the bcrypt the password
public class EcommerceUserAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceUserAuthServiceApplication.class, args);
	}

}

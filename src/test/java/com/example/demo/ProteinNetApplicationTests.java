package com.example.demo;

import com.example.demo.accessingdatamysql.User;
import com.example.demo.accessingdatamysql.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.Period;

@SpringBootTest
class ProteinNetApplicationTests {
	@Mock
	private UserRepository userRepository;

	@Test
	public void testAge() {
		// Create a User object with a known birth date
		User user = new User();
		LocalDate birthDate = LocalDate.of(1990, 5, 15);
		user.setBirthDate(birthDate);

		// Calculate the expected age based on the current date
		LocalDate currentDate = LocalDate.now();
		Integer expectedAge = Period.between((birthDate), currentDate).getYears();

		// Call the getAge() method and assert the result
		int actualAge = user.getAge();
		assertEquals(expectedAge, actualAge, "Test Passed");
	}

}

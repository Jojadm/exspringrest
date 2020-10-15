package be.abis.exercise.ut;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@SpringBootTest
public class TestApiPersonService {

	@Autowired
	PersonService ps;
	
	@Test
	public void testApiPersonService() {
		Person p = ps.findPerson(22);
		assertEquals("Lady",p.getFirstName());
		
		
	}

}

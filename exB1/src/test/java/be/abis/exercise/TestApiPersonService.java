package be.abis.exercise;

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
	public void testApiPersonServiceforId22() {
		Person p = ps.findPerson(22);
		assertEquals("Lady",p.getFirstName());
		
		
	}
	@Test
	public void testApiPersonServiceforId2() {
		Person p = ps.findPerson(2);
		assertEquals("Lady",p.getFirstName());
		
		
	}

}

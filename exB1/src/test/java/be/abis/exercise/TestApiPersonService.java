package be.abis.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApiPersonService {

	@Autowired
	PersonService ps;
	
	@Test
	public void testApiPersonServiceforfindById22() {
		Person p = ps.findPerson(22);
		assertEquals("Lady",p.getFirstName());
	}
	
	@Test
	public void testApiPersonServiceforlogin() {
		Person p = ps.findPerson("sonja_dm@telenet.be", "ikke132");
		System.out.println("Person: " +p);
		//assertEquals("Mary",p.getFirstName());
	}
	
	@Test
	public void testApiPersonServiceforDelete() throws PersonCanNotBeDeletedException {
		ps.deletePerson(10);
		Person checkp = ps.findPerson(10);
		assertTrue(checkp==null);
	}
	
	@Test
	public void testApiPersonServiceforAddPerson() throws IOException {
		int index=225;
		Address a = new Address();
		a.setStreet("Plein");
		a.setNr(44);
		a.setZipcode("1000");
		a.setTown("Brussel");
		
		Company c = new Company();
		c.setName("Belfius");
		c.setTelephoneNumber("022224988");
		c.setVatNr("123456789");
		c.setAddress(a);
		
		Person p = new Person();
		p.setPersonId(index);
		p.setFirstName("Steve");
		p.setLastName("Samson");
		p.setAge(33);
		p.setLanguage("NL");
		p.setEmailAddress("s"+index+"@gmail.com");
		p.setPassword("password");
		p.setCompany(c);
		
		ps.addPerson(p);
		Person checkp = ps.findPerson(index);
		assertEquals("Steve",checkp.getFirstName());
	
	}

}

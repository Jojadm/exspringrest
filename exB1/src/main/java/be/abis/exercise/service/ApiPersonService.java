package be.abis.exercise.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;

@Service
public class ApiPersonService implements PersonService {
	
	@Autowired
	RestTemplate rt;
	
	String baseUrl="http://localhost:8084/exercise/api/persons";
	
	@Override
	public Person findPerson(int id) {
		// TODO Auto-generated method stub
		Person p = rt.getForObject(baseUrl+"/"+id, Person.class);
		return p;
	}
		
	@Override
	public void addPerson(Person p) throws IOException  {
		// TODO Auto-generated method stub
		rt.postForObject(baseUrl, p, void.class);
	}
	

	@Override
	public void deletePerson(int id) throws PersonCanNotBeDeletedException {
		rt.delete(baseUrl+"/"+id);
		// TODO Auto-generated method stub
	}

	@Override
	public void changePassword(Person p, String newPswd) throws IOException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Person findPerson(String emailAddress, String passWord) {
		// TODO Auto-generated method stub
		Login login = new Login ();
		login.setEmail(emailAddress);
		login.setPassword(passWord);
		System.out.println("login email: " +login.getEmail());
		System.out.println("login pw: " +login.getPassword());
		Person p = rt.postForObject(baseUrl+"/login", login, Person.class);
		return p;
	}
	
	@Override
	public ArrayList<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}

package be.abis.exercise.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Password;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService ps;
	
	@GetMapping("/persons/{id}")
	public Person findPersonbyId(@PathVariable("id") int id) {
		Person p = ps.findPerson(id) ;
		return p;
	}
	
	@GetMapping("/persons")
	public ArrayList<Person> getAllPersons() {
		ArrayList<Person> persons = ps.getAllPersons();
		return persons;
	}
	
	@PostMapping("/persons/login")
	public Person findPersonByEmail(@RequestBody Login login) {
		Person p = ps.findPerson(login.getEmailAddress(), login.getPassword()) ;
		return p;
	}
  
	@PostMapping("/persons")
	public void addPerson(@RequestBody Person person) {
		try {
			ps.addPerson(person);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DeleteMapping("/persons/{id}")
	public void deletePerson(@PathVariable("id") int id) {
		try {
			ps.deletePerson(id);
		} catch (PersonCanNotBeDeletedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PutMapping("/persons/{id}/password")
	public void changePassword(@PathVariable("id") int id, @RequestBody Password password) {
		try {
			ps.changePassword(ps.findPerson(id), password.getPassword());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

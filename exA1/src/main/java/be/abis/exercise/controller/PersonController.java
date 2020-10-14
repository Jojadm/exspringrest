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
	
	@GetMapping("/persons/login")
	public Person findPersonByEmail(@RequestBody Person person) {
		Person p = ps.findPerson(person.getEmailAddress(), person.getPassword()) ;
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
	
	@PutMapping("/persons/{id}")
	public void changePassword(@PathVariable("id") int id, @RequestBody Person person) {
		Person p = ps.findPerson(id);
		try {
			ps.changePassword(p, person.getPassword());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

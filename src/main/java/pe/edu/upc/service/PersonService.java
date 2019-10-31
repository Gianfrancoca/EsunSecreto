package pe.edu.upc.service;

import java.util.Collection;

import pe.edu.upc.model.Person;

public interface PersonService {

	public abstract int createPerson(Person person);
	public abstract int updatePerson(Long id, Person person);
	public abstract int deletePerson(Long id);
	public abstract Collection<Person>getPeople();
}

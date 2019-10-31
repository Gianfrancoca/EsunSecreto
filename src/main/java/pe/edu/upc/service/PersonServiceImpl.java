package pe.edu.upc.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Person;
import pe.edu.upc.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	@Transactional
	public int createPerson(Person person) {
		// TODO Auto-generated method stub
		int result = personRepository.countByName(person.getFirstname());
		if(result==0) {
			personRepository.save(person);
		}
		return result;
	}

	@Override
	public int updatePerson(Long id, Person person) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Person> originalPerson = personRepository.findById(id);
		if(originalPerson.isPresent()) {
			Person updatedPerson = originalPerson.get();
			updatedPerson.setFirstname(person.getFirstname());
			updatedPerson.setLastname(person.getLastname());
			updatedPerson.setEmail(person.getEmail());
			updatedPerson.setDni(person.getDni());
			updatedPerson.setPhone(person.getPhone());
			personRepository.save(updatedPerson);
		}
		return result;
	}

	@Override
	public int deletePerson(Long id) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Person> person = personRepository.findById(id);
		person.ifPresent(p -> personRepository.delete(p));
		result = person.isPresent() ? 0 : -1;
		return result;
	}

	@Override
	public Collection<Person> getPeople() {
		// TODO Auto-generated method stub
		return personRepository.findAllByOrderByNameDesc();
	}

}

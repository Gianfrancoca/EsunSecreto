package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("select count(p.firstname) from Person p where p.firstname = :name")
	public int countByName(@Param("firstname") String personFirstname);
	public List<Person> findAllByOrderByNameDesc();
}

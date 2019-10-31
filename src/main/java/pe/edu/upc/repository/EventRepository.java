package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	@Query("select count(e.name) from Event e where e.name=:name")
	public int countByName(@Param("name") String eventName);
	public List<Event> findAllByOrderByNameDesc();
}

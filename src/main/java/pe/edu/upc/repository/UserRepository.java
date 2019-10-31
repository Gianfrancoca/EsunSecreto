package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select count(u.name) from User u where u.name=:name")
	public int countByName(@Param("username") String userName);
	public List<User> findAllByOrderByNameDesc();
}

package pe.edu.upc.service;

import java.util.Collection;

import pe.edu.upc.model.User;

public interface UserService {

	public abstract int createUser(User user);
	public abstract int updateUser(Long id, User user);
	public abstract int deleteUser(Long id);
	public abstract Collection<User> getUsers();
}

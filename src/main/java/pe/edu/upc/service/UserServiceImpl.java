package pe.edu.upc.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.User;
import pe.edu.upc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public int createUser(User user) {
		// TODO Auto-generated method stub
		int result = userRepository.countByName(user.getUsername());
		if	(result == 0) {
			userRepository.save(user);
		}
		return result;
	}

	@Override
	public int updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<User> originalUser = userRepository.findById(id);
		result = originalUser.isPresent() ? 0 : -1;
		User updatedUser = originalUser.get();
		updatedUser.setUsername(user.getUsername());
		updatedUser.setPassword(user.getPassword());
		userRepository.save(updatedUser);
		return result;
	}

	@Override
	public int deleteUser(Long id) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<User> user = userRepository.findById(id);
		user.ifPresent(u -> userRepository.delete(u));
		result = user.isPresent() ? 0 : -1;
		return result;
	}

	@Override
	public Collection<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAllByOrderByNameDesc();
	}

}

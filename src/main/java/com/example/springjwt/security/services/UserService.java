package com.example.springjwt.security.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springjwt.models.User;
import com.example.springjwt.repository.UserRepository;




@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> findById(int id) {
		return userRepository.findById((long) id);
	}
	public <S extends User> S save(S entity) {
		return userRepository.save(entity);
	}
	public Boolean deleteById(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return !userRepository.existsById(id);
		}
		return false;
	}

	public void delete(User entity) {
		userRepository.delete(entity);
	}
	


	
}

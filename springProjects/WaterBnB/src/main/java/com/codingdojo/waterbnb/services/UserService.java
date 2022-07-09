package com.codingdojo.waterbnb.services;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.codingdojo.waterbnb.models.User;
import com.codingdojo.waterbnb.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository; 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder =  bCryptPasswordEncoder;
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
} 

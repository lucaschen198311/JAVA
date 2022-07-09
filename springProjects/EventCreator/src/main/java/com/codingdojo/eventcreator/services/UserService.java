package com.codingdojo.eventcreator.services;

import org.springframework.stereotype.Service;
import com.codingdojo.eventcreator.models.User;
import com.codingdojo.eventcreator.repositories.RoleRepository;
import com.codingdojo.eventcreator.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
	private final UserRepository userRepo;
	private final RoleRepository roleRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public UserService(UserRepository userRepo, BCryptPasswordEncoder bCryptPasswordEncoder,RoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.roleRepo = roleRepo;
	}
	
	public User findUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }
	
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public void createUser(User user) {
		user.setRoles(roleRepo.findByName("ROLE_USER"));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepo.save(user);
	}
}

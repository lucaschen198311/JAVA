package com.codingdojo.admin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.admin.models.User;

public interface UserRepositories extends CrudRepository<User, Long>{
	List<User> findAll();
	void deleteById(Long id);
	User findByUsername(String username);
}

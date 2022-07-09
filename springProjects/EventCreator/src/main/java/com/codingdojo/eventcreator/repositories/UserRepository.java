package com.codingdojo.eventcreator.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.eventcreator.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
	User findByUsername(String username);
}

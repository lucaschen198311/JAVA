package com.codingdojo.waterbnb.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.waterbnb.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
	User findByUsername(String username);
}

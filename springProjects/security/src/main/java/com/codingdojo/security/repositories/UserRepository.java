package com.codingdojo.security.repositories;

//import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.security.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}

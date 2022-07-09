package com.codingdojo.authentication.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.codingdojo.authentication.models.User;

@Service
public interface UserRepository extends CrudRepository<User, Long>{
	Optional<User> findByEmail(String email);
}

package com.codingdojo.security.repositories;

import java.util.List;
//import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.security.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	List<Role> findAll();
	List<Role> findByName(String name);
}

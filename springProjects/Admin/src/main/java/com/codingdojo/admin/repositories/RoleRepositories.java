package com.codingdojo.admin.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.admin.models.Role;

public interface RoleRepositories extends CrudRepository<Role, Long>{
	List<Role> findAll();
	List<Role> findByName(String name);
}

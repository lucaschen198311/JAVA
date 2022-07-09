package com.codingdojo.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.Dorm;

public interface DormRepository extends CrudRepository<Dorm, Long>{
	List<Dorm> findAll();
	
}

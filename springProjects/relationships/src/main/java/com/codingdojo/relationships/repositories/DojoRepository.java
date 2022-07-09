package com.codingdojo.relationships.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
	
}

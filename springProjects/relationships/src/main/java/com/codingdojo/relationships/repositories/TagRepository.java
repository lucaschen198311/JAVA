package com.codingdojo.relationships.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	Optional<Tag> findBySubject(String subject);
}

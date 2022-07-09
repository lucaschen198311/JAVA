package com.codingdojo.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
}

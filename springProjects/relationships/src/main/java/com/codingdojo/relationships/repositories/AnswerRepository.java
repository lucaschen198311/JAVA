package com.codingdojo.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
}

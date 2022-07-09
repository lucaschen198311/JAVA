package com.codingdojo.eventcreator.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.eventcreator.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{
	List<Comment> findAll();
}

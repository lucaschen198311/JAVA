package com.codingdojo.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.Stack;
import com.codingdojo.relationships.models.Student;

public interface StackRepository extends CrudRepository<Stack, Long>{
	List<Stack> findAll();
	//Retrieves a list of stacks a particular student does not have.
	List<Stack> findByStudentsNotContains(Student student);
	// Retrieves a list of all stacks for a particular student
	List<Stack> findAllByStudents(Student student);
}

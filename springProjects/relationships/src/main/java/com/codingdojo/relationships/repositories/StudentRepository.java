package com.codingdojo.relationships.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();
	List<Student> findByDormIsNull();
	@Query(value="SELECT s.* FROM students s LEFT OUTER JOIN contacts c ON s.id = c.student_id WHERE c.id IS NULL", nativeQuery=true)
	List<Student> findByNoContact();
	
	List<Student> findByContactIdIsNull();
}

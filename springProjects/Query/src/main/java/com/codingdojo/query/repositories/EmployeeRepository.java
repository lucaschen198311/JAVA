package com.codingdojo.query.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.query.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	List<Employee> findAll();
	@Query("SELECT m.firstName, m.lastName FROM Employee e JOIN e.manager m WHERE e.id = ?1")
	Object[] checkManager(Integer id);
	@Query("SELECT es.firstName, es.lastName FROM Employee e JOIN e.employees es WHERE e.id = ?1")
	List<Object[]> checkEmployees(Integer id);
}

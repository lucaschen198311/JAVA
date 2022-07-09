package com.codingdojo.query.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.codingdojo.query.repositories.EmployeeRepository;
import com.codingdojo.query.models.Employee;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepo;
	public EmployeeService(EmployeeRepository repo) {
		this.employeeRepo = repo;
	}
	
	public List<Employee> getAllEmployees(){
		return this.employeeRepo.findAll();
	}
	
	public Employee getOneEmployee(Integer id) {
		return this.employeeRepo.findById(id).orElse(null);
	}

	public Object[] getManager(Integer id) {
		return this.employeeRepo.checkManager(id);
	}

	public List<Object[]> getEmployees(Integer id){
		return this.employeeRepo.checkEmployees(id);
	}
	
}

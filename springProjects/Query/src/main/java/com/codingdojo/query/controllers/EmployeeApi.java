package com.codingdojo.query.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codingdojo.query.services.EmployeeService;
import com.codingdojo.query.models.Employee;

@RestController
public class EmployeeApi {
	private final EmployeeService employeeService;
	public EmployeeApi(EmployeeService service) {
		this.employeeService = service;
	}
	
	@RequestMapping("/api/employees")
	public List<Employee> index(){
		return this.employeeService.getAllEmployees();
	}
	
	@RequestMapping("/api/employees/{id}")
	public Employee getOneEmployee(@PathVariable("id") Integer id) {
		return this.employeeService.getOneEmployee(id);
	}

	@RequestMapping("/api/employees/{id}/manager")
	public Object[] getEmployeeManager(@PathVariable("id") Integer id) {
		return this.employeeService.getManager(id);
	}
	
	@RequestMapping("/api/employees/{id}/employees")
	public List<Object[]> getManagerEmployee(@PathVariable("id") Integer id){
		return this.employeeService.getEmployees(id);
	}
	
}

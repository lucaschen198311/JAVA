package com.codingdojo.relationships.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.codingdojo.relationships.models.Stack;
import com.codingdojo.relationships.models.Student;
import com.codingdojo.relationships.repositories.StackRepository;
import com.codingdojo.relationships.repositories.StudentRepository;

@Service
public class StackService {
	private final StackRepository stackRepository;
	private final StudentRepository studentRepository;
	public StackService(StackRepository stackRepo, StudentRepository studentRepo) {
		this.stackRepository = stackRepo;
		this.studentRepository = studentRepo;
	}
	
	public List<Stack> finalAllStacks(){
		return stackRepository.findAll();
	}
	
	public List<Student> finalAllStudents(){
		return studentRepository.findAll();
	}
	
	public Stack findStack(Long id) {
		return stackRepository.findById(id).orElse(null);
	}
	
	public Student findStudent(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public Stack createStack(Stack s) {
		return this.stackRepository.save(s);
	}
	
	public List<Stack> findStacksNotInStudent(Student student){
		return stackRepository.findByStudentsNotContains(student);
	}
	
	public List<Stack> findStacksInStudent(Student student){
		return stackRepository.findAllByStudents(student);
	}
	
	public Student addStackIntoStudent(Long stackId, Long studentId) {
		Stack stack = stackRepository.findById(stackId).orElse(null);
		Student student = studentRepository.findById(studentId).orElse(null);
		student.getStacks().add(stack);
		return studentRepository.save(student);
	}
	
	public Student dropStackFromStudent(Long stackId, Long studentId) {
		Stack stack = stackRepository.findById(stackId).orElse(null);
		Student student = studentRepository.findById(studentId).orElse(null);
		student.getStacks().remove(stack);
		return studentRepository.save(student);
	}
}

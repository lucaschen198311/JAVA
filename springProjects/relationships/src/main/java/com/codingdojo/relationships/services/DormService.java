package com.codingdojo.relationships.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.codingdojo.relationships.models.Dorm;
import com.codingdojo.relationships.models.Student;
import com.codingdojo.relationships.repositories.DormRepository;
import com.codingdojo.relationships.repositories.StudentRepository;

@Service
public class DormService {
	private final DormRepository dormRepository;
	private final StudentRepository studentRepository;
	public DormService(DormRepository dormRepo, StudentRepository studentRepo) {
		this.dormRepository = dormRepo;
		this.studentRepository = studentRepo;
	}
	
	public Dorm createDorm(Dorm d) {
		return dormRepository.save(d);
	}
	
	public List<Dorm> findAllDorms(){
		return dormRepository.findAll();
	}
	
	public Dorm findDorm(Long id){
		return dormRepository.findById(id).orElse(null);
	}
	
	public List<Student> findStudentsNotInDorm() {
		return studentRepository.findByDormIsNull();
	}
	
	public Dorm addStudentIntoDorm(Long dormId, Long studentId) {
		Dorm dorm = dormRepository.findById(dormId).orElse(null);
		Student student = studentRepository.findById(studentId).orElse(null);
		dorm.getStudents().add(student);
		student.setDorm(dorm);
		return dormRepository.save(dorm);
	}
	
	public Dorm removeStudentFromDorm(Long dormId, Long studentId) {
		Dorm dorm = dormRepository.findById(dormId).orElse(null);
		Student student = studentRepository.findById(studentId).orElse(null);
		dorm.getStudents().remove(student);
		student.setDorm(null);
		return dormRepository.save(dorm);
	}
}

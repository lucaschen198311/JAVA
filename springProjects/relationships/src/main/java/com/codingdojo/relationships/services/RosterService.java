package com.codingdojo.relationships.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.codingdojo.relationships.models.Contact;
import com.codingdojo.relationships.models.Student;
import com.codingdojo.relationships.repositories.ContactRepository;
import com.codingdojo.relationships.repositories.StudentRepository;

@Service
public class RosterService {
	private final StudentRepository studentRepository;
	private final ContactRepository contactRepository;
	
	public RosterService(StudentRepository studentRepository, ContactRepository contactRepository) {
		this.studentRepository = studentRepository;
		this.contactRepository = contactRepository;
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public List<Student> getUncontactdStudents() {
		return studentRepository.findByContactIdIsNull();
	}
	
	public Student createStudent(Student s) {
		return studentRepository.save(s);
	}
	
	public Contact createContact(Contact c) {
		return contactRepository.save(c);
	}
}

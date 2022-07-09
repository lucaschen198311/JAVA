package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.LicenseRepository;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class DMVService {
	private final PersonRepository personRepository;
	private final LicenseRepository licenseRepository;
	
	public DMVService(PersonRepository personRepository, LicenseRepository licenseRepository) {
		this.personRepository = personRepository;
		this.licenseRepository = licenseRepository;
	}
	
	public Person findPerson(Long id) {
		Optional<Person> optionalperson = personRepository.findById(id);
		if(optionalperson != null) {
			return optionalperson.get();
		}else {
			return null;
		}
	}
	
	public List<Person> getAllPeople() {
		return personRepository.findAll();
	}
	
	public List<Person> getUnlicensedPeople() {
		return personRepository.findByLicenseIdIsNull();
	}
	
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	
	public License createLicense(License l) {
		l.setNumber(this.generateLicenseNumber());
		return licenseRepository.save(l);
	}
	public Integer generateLicenseNumber() {
		License l = licenseRepository.findTopByOrderByNumberDesc();
		if(l == null)
			return 1;
		Integer largestNumber = l.getNumber();
		largestNumber++;
		return largestNumber;
	}

}

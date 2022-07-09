package com.codingdojo.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	List<Contact> findAll();
}

package com.codingdojo.eventcreator.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.eventcreator.models.Event;

public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event> findAll();
	Optional<Event> findById(Long id);
	List<Event> findByState(String state);
	List<Event> findByStateNot(String state);
	void deleteById(Long id);
}

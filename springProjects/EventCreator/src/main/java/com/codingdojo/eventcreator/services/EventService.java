package com.codingdojo.eventcreator.services;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.codingdojo.eventcreator.repositories.EventRepository;
import com.codingdojo.eventcreator.repositories.UserRepository;
import com.codingdojo.eventcreator.models.Event;
import com.codingdojo.eventcreator.models.User;

@Service
public class EventService {
	private final EventRepository eventRepo;
	private final UserRepository userRepo;
	public EventService(EventRepository eventRepo, UserRepository userRepo) {
		this.eventRepo = eventRepo;
		this.userRepo = userRepo;
	}
	
	public List<Event> findEventsInSameSate(String state){
		return eventRepo.findByState(state);
	}
	
	public List<Event> findEventsInDifferentState(String state){
		return eventRepo.findByStateNot(state);
	}
	
	public Event createNewEvent(Event event, String username) {
		User user = userRepo.findByUsername(username);
		event.setHostBy(user.getId());
		event.setHostName(user.getFirstName() + " " + user.getLastName());
		return eventRepo.save(event);
	}
	
	public Event editEvent(User user, Event event) {
		//Event event = this.findEvent(id);
		//event.setName(name);
		//event.setHostDate(hostDate);
		//event.setLocation(location);
		//event.setState(state);
		event.setHostBy(user.getId());
		event.setHostName(user.getFirstName() + " " + user.getLastName());
		return eventRepo.save(event);
	}
	
	public Event findEvent(Long id) {
		return eventRepo.findById(id).orElse(null);
	}
	
	public int countPeopleJoinEvent(Long id) {
		Event event = this.findEvent(id);
		return event.getUsers().size();
	}
	
	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
	}
	
	public Event joinEvent(String username, Long eventId) {
		User user = userRepo.findByUsername(username);
		Event event = this.findEvent(eventId);
		event.getUsers().add(user);
		return eventRepo.save(event);
	}
	
	public Event cancelJoinEvent(String username, Long eventId) {
		User user = userRepo.findByUsername(username);
		Event event = this.findEvent(eventId);
		event.getUsers().remove(user);
		return eventRepo.save(event);
	}
}

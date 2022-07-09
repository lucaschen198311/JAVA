package com.codingdojo.eventcreator.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.codingdojo.eventcreator.models.Comment;
import com.codingdojo.eventcreator.models.Event;
import com.codingdojo.eventcreator.models.User;
import com.codingdojo.eventcreator.repositories.CommentRepository;
import com.codingdojo.eventcreator.repositories.EventRepository;
import com.codingdojo.eventcreator.repositories.UserRepository;

@Service
public class CommentService {
	private final CommentRepository commentRepo;
	private final UserRepository userRepo;
	private final EventRepository eventRepo;
	public CommentService(CommentRepository commentRepo, UserRepository userRepo, EventRepository eventRepo) {
		this.commentRepo = commentRepo;
		this.userRepo = userRepo;
		this.eventRepo = eventRepo;
	}
	
	public Comment addNewComment(Comment comment, Long eventId, String username) {
		User user = userRepo.findByUsername(username);
		Event event = eventRepo.findById(eventId).orElse(null);
		String content = comment.getContent();
		Long commentBy = user.getId();
		String commentName = user.getFirstName() + " " + user.getLastName();
		return commentRepo.save(new Comment(content, commentBy, commentName, event));
	}
	
	public List<Comment> findAllCommentsFromEvent(Long eventId){
		Event event = eventRepo.findById(eventId).orElse(null);
		List<Comment> comments = event.getComments();
		return comments;
	}
}

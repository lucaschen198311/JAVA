package com.codingdojo.eventcreator.controllers;

import java.security.Principal;
//import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.codingdojo.eventcreator.models.User;
import com.codingdojo.eventcreator.models.Comment;
import com.codingdojo.eventcreator.models.Event;
import com.codingdojo.eventcreator.services.CommentService;
import com.codingdojo.eventcreator.services.EventService;
import com.codingdojo.eventcreator.services.UserService;
import com.codingdojo.eventcreator.validator.UserValidator;

@Controller
public class EventController {
	private final UserService userService;
	private final EventService eventService;
	private final CommentService commentService;
	private UserValidator userValidator;
	public EventController(UserValidator userValidator, UserService userService, EventService eventService, CommentService commentService) {
		this.userService = userService;
		this.eventService = eventService;
		this.commentService = commentService;
		this.userValidator = userValidator;
	}
	
	public void getInfoForDashboard(String username, Model model) {
		User user = userService.findByUsername(username);
		List<Event> eventsWithinState = eventService.findEventsInSameSate(user.getState());
		List<Event> eventsOutOfState = eventService.findEventsInDifferentState(user.getState());
		model.addAttribute("currUser", user);
		model.addAttribute("eventsInState", eventsWithinState);
		model.addAttribute("eventsOutState", eventsOutOfState);
	}
	
	public void getInfoForEventPage(Long id, Model model) {
		Event event = eventService.findEvent(id);
		int count = eventService.countPeopleJoinEvent(id);
		List<Comment> comments = commentService.findAllCommentsFromEvent(id);
		model.addAttribute("count", count);
		model.addAttribute("event", event);
		model.addAttribute("comments", comments);
		model.addAttribute("attendees", event.getUsers());
	}
	
	@RequestMapping("/registlogin")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registloginPage.jsp";
    }
	
	@RequestMapping(value = "/registlogin", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
            return "registloginPage.jsp";
        }
        userService.createUser(user);
        return "redirect:/login";
    }
	
	@RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "registloginPage.jsp";
    }
	
	@RequestMapping(value = {"/events", "/"})
	public String home(@Valid @ModelAttribute("event") Event event, Principal principal, Model model) {
		//principal (current user) via the .getName() method has been available since Spring 3+
		String username = principal.getName();
		this.getInfoForDashboard(username, model);
	    return "dashboardPage.jsp";
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Principal principal, Model model) {
		//principal (current user) via the .getName() method has been available since Spring 3+
		String username = principal.getName();
		if(result.hasErrors()) {
			this.getInfoForDashboard(username, model);
		    return "dashboardPage.jsp";
		}
		eventService.createNewEvent(event, username);
		return "redirect:/events";
		//return "dashboardPage.jsp";
	}
	
	@RequestMapping("/events/{id}")
	public String showEvent(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("comment") Comment comment) {
		//principal (current user) via the .getName() method has been available since Spring 3+
		this.getInfoForEventPage(id, model);
		return "eventPage.jsp";
	}
	
	@RequestMapping(value = "/events/{id}/addcomment", method = RequestMethod.POST)
	public String addCommentToEvent(@Valid @ModelAttribute("comment") Comment comment, BindingResult result, @PathVariable("id") Long id, Principal principal, Model model) {
		//principal (current user) via the .getName() method has been available since Spring 3+
		String username = principal.getName();
		
		if(result.hasErrors()) {
			this.getInfoForEventPage(id, model);
			return "eventPage.jsp";
		}
		commentService.addNewComment(comment, id, username);
		return "redirect:/events/{id}";
	}
	
	@RequestMapping(value = "/events/{id}/delete", method = RequestMethod.POST)
	public String deleteEvent(@PathVariable("id") Long id) {
		eventService.deleteEvent(id);
		return "redirect:/events";
	}
	
	@RequestMapping(value = "/events/{id}/join", method = RequestMethod.POST)
	public String joinEvent(@PathVariable("id") Long id, Principal principal) {
		//principal (current user) via the .getName() method has been available since Spring 3+
		String username = principal.getName();
		eventService.joinEvent(username, id);
		return "redirect:/events";
	}
	
	@RequestMapping(value = "/events/{id}/cancel", method = RequestMethod.POST)
	public String cancelJoinEvent(@PathVariable("id") Long id, Principal principal) {
		//principal (current user) via the .getName() method has been available since Spring 3+
		String username = principal.getName();
		eventService.cancelJoinEvent(username, id);
		return "redirect:/events";
	}
	
	@RequestMapping("/events/{id}/edit")
	public String showEditEvent(@PathVariable("id") Long id, Model model) {
		Event event = eventService.findEvent(id);
		model.addAttribute("event", event);
		return "editEventPage.jsp";
	}
	/*
	@RequestMapping(value = "/events/{id}/edit", method = RequestMethod.POST)
	public String editEvent(@PathVariable("id") Long id, @RequestParam(value="name" ) String name, @RequestParam(value="hostDate")  @DateTimeFormat(pattern="yyyy-MM-dd") Date hostDate, @RequestParam(value="location") String location, @RequestParam(value="state") String state) {
		eventService.editEvent(id, name, hostDate, location, state);
		return "redirect:/events";
	}
	*/
	@RequestMapping(value = "/events/{id}/edit", method = RequestMethod.POST)
	public String editEvent(@PathVariable("id") Long id, @Valid @ModelAttribute("event") Event event, BindingResult result, Principal principal) {
		String username = principal.getName();
		User user = userService.findByUsername(username);
		if(result.hasErrors()) {
			return "editEventPage.jsp";
		}
		eventService.editEvent(user, event);
		return "redirect:/events";
	}
}

package com.codingdojo.relationships.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.codingdojo.relationships.models.Contact;
import com.codingdojo.relationships.models.Student;
import com.codingdojo.relationships.services.RosterService;

@Controller
public class RosterController {
	private final RosterService rosterService;
	public RosterController(RosterService service) {
		this.rosterService = service;
	}
	@RequestMapping("/students")
	public String index(Model model) {
		model.addAttribute("students", rosterService.getAllStudents());
		return "/roster/index.jsp";
	}
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "/roster/newstudent.jsp";
	}
	@RequestMapping(value="/students", method=RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors() ) {
			return "/roster/newstudent.jsp";
		}
		rosterService.createStudent(student);
		return "redirect:/students";
	}
	@RequestMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
		List<Student> uncontacted = rosterService.getUncontactdStudents();
		model.addAttribute("students", uncontacted);
		return "/roster/newcontact.jsp";
	}
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
		if(result.hasErrors() ) {
			return "/roster/newcontact.jsp";
		}
		rosterService.createContact(contact);
		return "redirect:/students";
	}
}

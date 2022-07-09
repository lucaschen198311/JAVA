package com.codingdojo.relationships.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.codingdojo.relationships.models.Dorm;
import com.codingdojo.relationships.models.Student;
import com.codingdojo.relationships.services.DormService;

@Controller
public class DormController {
	private final DormService dormService;
	public DormController(DormService service) {
		this.dormService = service;
	}
	
	@RequestMapping("/dorms")
	public String index(Model model) {
		model.addAttribute("dorms", dormService.findAllDorms());
		return "/dorm/index.jsp";
	}
	
	@RequestMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "/dorm/newdorm.jsp";
	}
	
	@RequestMapping(value="/dorms", method=RequestMethod.POST)
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if(result.hasErrors())
			return "/dorm/newdorm.jsp";
		this.dormService.createDorm(dorm);
		return "redirect:/dorms";
	}
	
	@RequestMapping("/dorms/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model) {
		Dorm dorm = dormService.findDorm(id);
		List<Student> occupyStudents = dorm.getStudents();
		List<Student> freeStudents = dormService.findStudentsNotInDorm();
		model.addAttribute("dorm", dorm);
		model.addAttribute("occupyStudents", occupyStudents);
		model.addAttribute("freeStudents", freeStudents);
		return "/dorm/showdorm.jsp";
	}
	
	@RequestMapping(value="/dorms/{id}", method=RequestMethod.POST)
	public String assignStudentIntoDorm(@RequestParam(value="studentId") Long studentId, @PathVariable("id") Long id) {
		dormService.addStudentIntoDorm(id, studentId);
		return "redirect:/dorms/{id}";
	}
	
	@RequestMapping(value="/dorms/{id}/students/remove", method=RequestMethod.POST)
	public String removeStudentFromDorm(@RequestParam(value="studentId") Long studentId, @PathVariable("id") Long id) {
		dormService.removeStudentFromDorm(id, studentId);
		return "redirect:/dorms/{id}";
	}
}

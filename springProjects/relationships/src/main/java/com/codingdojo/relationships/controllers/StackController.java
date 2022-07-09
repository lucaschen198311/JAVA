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
import com.codingdojo.relationships.models.Stack;
import com.codingdojo.relationships.models.Student;
import com.codingdojo.relationships.services.StackService;

@Controller
public class StackController {
	private final StackService stackService;
	public StackController(StackService stackService) {
		this.stackService = stackService;
	}
	
	@RequestMapping("/stackhome")
	public String stackhompage(Model model) {
		model.addAttribute("students", stackService.finalAllStudents());
		model.addAttribute("stacks", stackService.finalAllStacks());
		return "/stack/index.jsp";
	}
	
	@RequestMapping("/stacks/new")
	public String newStack(@ModelAttribute("stack") Stack stack) {
		return "/stack/newstack.jsp";
	}
	
	@RequestMapping(value="/stacks", method=RequestMethod.POST)
	public String createStack(@Valid @ModelAttribute("stack") Stack stack, BindingResult result) {
		if(result.hasErrors())
			return "/stack/newstack.jsp";
		this.stackService.createStack(stack);
		return "redirect:/stackhome";
	}
	
	@RequestMapping("/stacks/{id}")
	public String showStack(@PathVariable("id") Long id, Model model) {
		model.addAttribute("stack", stackService.findStack(id));
		model.addAttribute("students", stackService.findStack(id).getStudents());
		return "/stack/showstack.jsp";
	}
	
	@RequestMapping("/students/{id}/stack")
	public String showStudentOfStacks(@PathVariable("id") Long id, Model model) {
		Student student = stackService.findStudent(id);
		List<Stack> currStacks = stackService.findStacksInStudent(student);
		List<Stack> otherStacks = stackService.findStacksNotInStudent(student);
		model.addAttribute("student", student);
		model.addAttribute("currStacks", currStacks);
		model.addAttribute("otherStacks", otherStacks);
		return "/stack/showstudentofstack.jsp";
	}
	
	@RequestMapping(value="/students/{id}/stack", method=RequestMethod.POST)
	public String addStackToStudent(@PathVariable("id") Long id, @RequestParam(value="stackId") Long stackId) {
		stackService.addStackIntoStudent(stackId, id);
		return "redirect:/students/{id}/stack";
	}
	
	@RequestMapping(value="/students/{id}/stack/remove", method=RequestMethod.POST)
	public String dropStackFromStudent(@PathVariable("id") Long id, @RequestParam(value="stackId") Long stackId) {
		stackService.dropStackFromStudent(stackId, id);
		return "redirect:/students/{id}/stack";
	}
}

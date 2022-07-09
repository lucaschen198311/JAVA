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
import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.DMVService;

@Controller
public class DMVController {
	private final DMVService service;
	public DMVController(DMVService serv) {
		this.service = serv;
	}
	@RequestMapping("/")
	public String Index(Model model) {
		List<Person> people = service.getAllPeople();
		model.addAttribute("persons", people);
		return "/onetoone/index.jsp";
	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String CreatePerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors() ) {
			return "/onetoone/newperson.jsp";
		}
		service.createPerson(person);
		return "redirect:/";
	}
	@RequestMapping("/{id}")
	public String ShowPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", service.findPerson(id));
		return "/onetoone/showperson.jsp";
	}
	@RequestMapping("/new")
	public String NewPerson(@ModelAttribute("person") Person person) {
		return "/onetoone/newperson.jsp";
	}
	@RequestMapping("/licenses/new")
	public String NewLicense(@ModelAttribute("license") License lic, Model model) {
		List<Person> unlicensed = service.getUnlicensedPeople();
		model.addAttribute("persons", unlicensed);
		return "/onetoone/newlicense.jsp";
	}
	@RequestMapping(value = "/licenses", method=RequestMethod.POST)
	public String CreateLicense(@Valid @ModelAttribute("license") License lic, BindingResult result) {
		if(result.hasErrors())
			return "/onetoone/newlicense.jsp";
		service.createLicense(lic);
		return "redirect:/";
	}
}

package com.codingdojo.relationships.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.codingdojo.relationships.models.Dojo;
import com.codingdojo.relationships.services.BootCampService;

@Controller
public class DojoController {
	private final BootCampService bootcampService;
	public DojoController(BootCampService service) {
		this.bootcampService = service;
	}
	@RequestMapping("/dojos")
	public String Index(Model model) {
		model.addAttribute("dojos", bootcampService.allDojos());
		return "/onetomany/indexdojo.jsp";
	}
	@RequestMapping("/dojos/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", this.bootcampService.findDojo(id));
		return "/onetomany/showdojo.jsp";
	}
	@RequestMapping("/dojos/new")
	public String New(@ModelAttribute("dojo") Dojo dojo) {
		return "/onetomany/newdojo.jsp";
	}
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors())
			return "/onetomany/newdojo.jsp";
		this.bootcampService.createDojo(dojo);
		return "redirect:/dojos";
	}
}

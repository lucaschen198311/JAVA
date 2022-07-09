package com.codingdojo.relationships.controllers;

//import java.util.ArrayList;
//import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.codingdojo.relationships.models.Dojo;
import com.codingdojo.relationships.models.Ninja;
import com.codingdojo.relationships.services.BootCampService;

@Controller
public class NinjaController {
	private BootCampService bootcampService;
	public NinjaController(BootCampService service) {
		this.bootcampService = service;
	}
	@RequestMapping("/ninjas")
	public String Index(Model model) {
		model.addAttribute("ninjas", this.bootcampService.allNinjas());
		return "/onetomany/indexninja.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String New(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", this.bootcampService.allDojos());
		return "/onetomany/newninja.jsp";
	}
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", this.bootcampService.allDojos());
			return "/ninjas/newninja.jsp";
		}
		this.bootcampService.createNinja(ninja);
		return "redirect:/ninjas";
	}
	
	//pagination:
	@RequestMapping("/ninjas/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax class="keyword operator from-rainbow">- 1.
	    Page<Object[]> ninjas = bootcampService.ninjasPerPage(pageNumber - 1);
	    // total number of pages that we have
	    int totalPages = ninjas.getTotalPages();
	    System.out.println(ninjas);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("ninjas", ninjas);
	    return "/onetomany/ninjapage.jsp";
	}
	
}

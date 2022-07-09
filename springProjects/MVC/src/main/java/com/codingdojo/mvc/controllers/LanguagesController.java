package com.codingdojo.mvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.models.Language;
//import org.springframework.web.bind.annotation.RequestParam;
import com.codingdojo.mvc.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
    
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @RequestMapping("/languages")
    public String index(Model model) {
    	List<Language> languages = languageService.allLanguages();
    	model.addAttribute("languages", languages);
    	return "/languages/index.jsp";
    }
    
    @RequestMapping("/languages/new")
    public String newLan(@ModelAttribute("language") Language language) {
    	return "/languages/new.jsp";
    }
    
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String createlanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
    	if(result.hasErrors()) {
    		return "/languages/new.jsp";
    	}else {
    		languageService.createLanguage(language);
    		return "redirect:/languages";
    	}
    }
    
    @RequestMapping("/languages/{id}")
    public String showlanguage(@PathVariable("id") Long id, Model model) {
    	Language lan = languageService.findLanguage(id);
    	if(lan != null) {
    		model.addAttribute("lan", lan);
        	return "/languages/showlan.jsp";
    	}
    	return null;
    }
    
    @RequestMapping("/languages/{id}/edit")
    public String editlanguage(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/editlan.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String updatelanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "/languages/editlan.jsp";
        } else {
            languageService.updateLanguage(id, language.getName(), language.getCreator(), language.getCurrentVersion());
            return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String deletelanguage(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}

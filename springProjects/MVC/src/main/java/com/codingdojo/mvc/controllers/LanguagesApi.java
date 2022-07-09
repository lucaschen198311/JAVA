package com.codingdojo.mvc.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codingdojo.mvc.models.Language;
import com.codingdojo.mvc.services.LanguageService;

@RestController
public class LanguagesApi {
	private final LanguageService languageService;
    public LanguagesApi(LanguageService languageService){
        this.languageService = languageService;
    }
    @RequestMapping("/api/languages")
    public List<Language> index() {
        return languageService.allLanguages();
    }
    
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
        Language lan = new Language(name, creator, currentVersion);
        return languageService.createLanguage(lan);
    }
    
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
    	Language lan = languageService.findLanguage(id);
        return lan;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
    	Language lan = languageService.updateLanguage(id, name, creator, currentVersion);
        return lan;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }
}

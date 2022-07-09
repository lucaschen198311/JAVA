package com.codingdojo.mvc.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Language;
import com.codingdojo.mvc.repositories.LanguageRepository;

@Service
public class LanguageService {
	// adding the book repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the language
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a language
    public Language createLanguage(Language lan) {
        return languageRepository.save(lan);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLan = languageRepository.findById(id);
        if(optionalLan.isPresent()) {
            return optionalLan.get();
        } else {
            return null;
        }
    }
    
    //update a language by id
    public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
    	Optional<Language> optionalLan = languageRepository.findById(id);
    	if(optionalLan.isPresent()) {
    		Language lan = optionalLan.get();
    		lan.setName(name);
    		lan.setCreator(creator);
    		lan.setCurrentVersion(currentVersion);
    		lan.setUpdatedAt(new Date());
    		return languageRepository.save(lan);
    	}else {
    		return null;
    	}
    }
    
    //delete a language by id
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
}

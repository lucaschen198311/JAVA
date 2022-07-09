package com.codingdojo.query.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.codingdojo.query.repositories.CityRepository;
import com.codingdojo.query.repositories.CountryRepository;
import com.codingdojo.query.repositories.LanguageRepository;
import com.codingdojo.query.models.Country;
import com.codingdojo.query.models.City;
import com.codingdojo.query.models.Language;

@Service
public class CountryService {
	private final CountryRepository countryRepo;
	private final LanguageRepository languageRepo;
	private final CityRepository cityRepo;
	public CountryService(CountryRepository cRepo, LanguageRepository lRepo, CityRepository ciRepo) {
		this.countryRepo = cRepo;
		this.languageRepo = lRepo;
		this.cityRepo = ciRepo;
	}
	
	public List<Country> getCountries() {
		return this.countryRepo.findConMonCountries();
	}
	public List<City> getCities() {
		return this.cityRepo.findAll();
	}
	public List<Language> getLanguages() {
		return (List<Language>) this.languageRepo.findAll();
	}
	public List<Country> getCountryByName(String name) {
		return this.countryRepo.findCountryByName(name);
	}
	public List<Object[]> getCountryByLanguage(String lang) {
		return this.countryRepo.findCountryByLang(lang);
	}
	public List<Object[]> getCountryByRegion() {
		return this.countryRepo.findCountryByRegion();
	}
	public List<Object[]> getCountriesByCityCount() {
		return this.countryRepo.findCountryCityCount();
	}
	public List<Object[]> getCountryLanguagues() {
		return this.languageRepo.findCountryLangs();
	}
	public List<City> getMexicanCities() {
		return this.cityRepo.mexicanCities();
	}
	public List<Object[]> getBuenosAiresCities() {
		return this.cityRepo.argentinaBuenosAires();
	}
}

package com.codingdojo.query.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codingdojo.query.models.City;
import com.codingdojo.query.models.Country;
import com.codingdojo.query.models.Language;
import com.codingdojo.query.services.CountryService;

@RestController
public class CountryApi {
	private final CountryService service;
	public CountryApi(CountryService serv) {
		this.service = serv;
	}
	
	@RequestMapping("/api")
	public List<Country> Index() {
		return this.service.getCountries();
	}
	@RequestMapping("/api/n/{name}")
	public List<Object[]> CountryByName(@PathVariable("name") String name) {
		return this.service.getCountryByLanguage(name);
	}
	@RequestMapping("/api/n/cityCount")
	public List<Object[]> CountryByCityCount() {
		return this.service.getCountriesByCityCount();
	}
	@RequestMapping("/api/n/region")
	public List<Object[]> CountryByRegion() {
		return this.service.getCountryByRegion();
	}
	@RequestMapping("/api/c")
	public List<City> Cities() {
		return this.service.getCities();
	}
	@RequestMapping("/api/c/mexico")
	public List<City> MexicanCities() {
		return this.service.getMexicanCities();
	}
	@RequestMapping("/api/c/arg")
	public List<Object[]> BACities() {
		return this.service.getBuenosAiresCities();
	}
	@RequestMapping("/api/l")
	public List<Language> Languages() {
		return this.service.getLanguages();
	}
	@RequestMapping("/api/l/c")
	public List<Object[]> CountryLangs() {
		return this.service.getCountryLanguagues();
	}
}

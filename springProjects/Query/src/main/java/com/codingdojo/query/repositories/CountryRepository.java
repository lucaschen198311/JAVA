package com.codingdojo.query.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.query.models.Country;

public interface CountryRepository extends CrudRepository<Country, Integer>{
	List<Country> findAll();
	@Query("SELECT c FROM Country c WHERE name LIKE %?1%")
	List<Country> findCountryByName(String name);
	//No.1: to get all the countries that speak Slovene? Should return the name of the country, language, and language percentage and arrange the result by language percentage in descending order.
	@Query("SELECT c.name, l.language, l.percentage FROM Country c INNER JOIN c.languages l WHERE l.language LIKE %?1% ORDER BY l.percentage DESC")
	List<Object[]> findCountryByLang(String lang);
	//No.2: to display the total number of cities for each country? Should return the name of the country and the total number of cities. Arrange the result by the number of cities in descending order.
	@Query("SELECT c.name, COUNT(ci.id) AS num_cities FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY num_cities DESC")
	List<Object[]> findCountryCityCount();
	//No.5: to get all the countries with Surface Area below 501 and Population greater than 100,000
	@Query("SELECT c FROM Country c WHERE c.surfaceArea < 501 AND c.population > 100000 ORDER BY c.population DESC")
	List<Country> findDenseCountries();
	//No.6: to get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years
	@Query("SELECT c FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.lifeExpectancy > 75 AND c.capital > 200")
	List<Country> findConMonCountries();
	//No.8: to summarize the number of countries in each region? Should display the name of the region and the number of countries. Arrange the result by the number of countries in descending order.
	@Query("SELECT c.region, COUNT(c.id) AS num_countries FROM Country c GROUP BY c.region ORDER BY num_countries DESC")
	List<Object[]> findCountryByRegion();
}

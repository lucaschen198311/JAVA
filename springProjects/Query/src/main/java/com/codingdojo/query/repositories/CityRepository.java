package com.codingdojo.query.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.query.models.City;

public interface CityRepository extends CrudRepository<City, Integer>{
	List<City> findAll();
	//No.3:  to get all the cities in Mexico with a population of greater than 500,000? Your query should arrange the result by population in descending order
	@Query("SELECT ci FROM City ci JOIN ci.country c WHERE c.name = 'Mexico' AND c.population > 500000 ORDER BY c.population DESC")
	List<City> mexicanCities();
	//No.7: to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? Return the Country Name, City Name, District, and Population.
	@Query("SELECT c.name AS countryName, ci.name AS cityName, ci.district, ci.population FROM City ci JOIN ci.country c WHERE c.name = 'Argentina' AND ci.district = 'Buenos Aires' AND c.population > 500000 ORDER BY ci.population DESC")
	List<Object[]> argentinaBuenosAires();
}

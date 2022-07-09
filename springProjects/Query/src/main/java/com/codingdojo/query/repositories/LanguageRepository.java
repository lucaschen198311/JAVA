package com.codingdojo.query.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.query.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer>{
	List<Language> findAll();
	//No.4: to get all languages in each country with a percentage greater than 89%? Arrange the result by percentage in descending order.
	@Query("SELECT c.name AS country, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > 89 ORDER BY l.percentage DESC")
	List<Object[]> findCountryLangs();
}

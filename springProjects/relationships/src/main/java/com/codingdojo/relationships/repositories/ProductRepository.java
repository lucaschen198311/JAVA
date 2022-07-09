package com.codingdojo.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.relationships.models.Category;
import com.codingdojo.relationships.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	//Retrieves a list of products a particular category does not belong to.
	List<Product> findByCategoriesNotContains(Category category);
	// Retrieves a list of all products for a particular category
	List<Product> findAllByCategories(Category category);
}

package com.codingdojo.relationships.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.codingdojo.relationships.models.Category;
import com.codingdojo.relationships.models.Product;
import com.codingdojo.relationships.repositories.CategoryRepository;
import com.codingdojo.relationships.repositories.ProductRepository;

@Service
public class InventoryService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public InventoryService(ProductRepository prodService, CategoryRepository cateService) {
		this.productRepository = prodService;
		this.categoryRepository = cateService;
	}
	
	public List<Product> findAllProducts() {
		return this.productRepository.findAll();
	}
	public Product findProduct(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}
	public List<Category> findAllCategories() {
		return this.categoryRepository.findAll();
	}
	public Category findCategory(Long id) {
		return this.categoryRepository.findById(id).orElse(null);
	}
	public Product createProduct(Product p) {
		return this.productRepository.save(p);
	}
	public Category createCategory(Category c) {
		return this.categoryRepository.save(c);
	}
	public Category addProdIntoCategory(Long prodId, Long cateId) {
		// retrieve an instance of a category using another method in the service.
	    Category thisCategory = this.findCategory(cateId);
	    // retrieve an instance of a product using another method in the service.
	    Product thisProduct = this.findProduct(prodId);
	    // add the product to this category's list of products
	    thisCategory.getProducts().add(thisProduct);
	    // Save thisCategory, since you made changes to its product list.
	    return categoryRepository.save(thisCategory);	
	}
	public Product addCateIntoProd(Long prodId, Long cateId) {
		// retrieve an instance of a category using another method in the service.
	    Category thisCategory = this.findCategory(cateId);
	    // retrieve an instance of a product using another method in the service.
	    Product thisProduct = this.findProduct(prodId);
	    // add the category to this products's list of categories
	    thisProduct.getCategories().add(thisCategory);
	    //Save thisProduct, since you made changes to its category list.
	    return productRepository.save(thisProduct);
	}
	public List<Product> findProductsNotInCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	public List<Product> findProductsInCategory(Category category) {
		return productRepository.findAllByCategories(category);
	}
	public List<Category> findCategoriesNotInProduct(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}
	public List<Category> findCategoriesInProduct(Product product) {
		return categoryRepository.findAllByProducts(product);
	}
}

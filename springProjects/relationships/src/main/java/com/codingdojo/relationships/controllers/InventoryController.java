package com.codingdojo.relationships.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.codingdojo.relationships.models.Category;
import com.codingdojo.relationships.models.Product;
import com.codingdojo.relationships.services.InventoryService;

@Controller
public class InventoryController {
	private InventoryService inventoryService;
	public InventoryController(InventoryService service) {
		this.inventoryService = service;
	}
	@RequestMapping("/inventory")
	public String index(Model model) {
		model.addAttribute("products", inventoryService.findAllProducts());
		model.addAttribute("categories", inventoryService.findAllCategories());
		return "/manytomany/index.jsp";
	}
	@RequestMapping("/products/new")
	public String newProd(@ModelAttribute("product") Product product) {
		return "/manytomany/newprod.jsp";
	}
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String createProd(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors())
			return "/manytomany/newprod.jsp";
		this.inventoryService.createProduct(product);
		return "redirect:/inventory";
	}
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/manytomany/newcategory.jsp";
	}
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors())
			return "/manytomany/newcategory.jsp";
		this.inventoryService.createCategory(category);
		return "redirect:/inventory";
	}
	@RequestMapping("/products/{id}")
	public String showProd(@PathVariable("id") Long id, Model model) {
		Product prod = inventoryService.findProduct(id);
		List<Category> currCategories = inventoryService.findCategoriesInProduct(prod);
		List<Category> otherCategories = inventoryService.findCategoriesNotInProduct(prod);
		model.addAttribute("product", prod);
		model.addAttribute("currCategories", currCategories);
		model.addAttribute("otherCategories", otherCategories);
		return "/manytomany/showprod.jsp";
	}
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category categ = inventoryService.findCategory(id);
		List<Product> currProds = inventoryService.findProductsInCategory(categ);
		List<Product> otherProds = inventoryService.findProductsNotInCategory(categ);
		model.addAttribute("category", categ);
		model.addAttribute("currProds", currProds);
		model.addAttribute("otherProds", otherProds);
		return "/manytomany/showcategory.jsp";
	}
	@RequestMapping(value="/products/{id}", method=RequestMethod.POST)
	public String addCategoryToProd(@PathVariable("id") Long id, @RequestParam(value="cateId") Long cateId) {
		inventoryService.addCateIntoProd(id, cateId);
		return "redirect:/products/{id}";
	}
	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
	public String addProdToCategory(@PathVariable("id") Long id, @RequestParam(value="prodId") Long prodId) {
		inventoryService.addProdIntoCategory(prodId, id);
		return "redirect:/categories/{id}";
	}
}

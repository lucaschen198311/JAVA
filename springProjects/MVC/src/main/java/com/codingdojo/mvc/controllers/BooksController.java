package com.codingdojo.mvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
    	List<Book> books = bookService.allBooks();
    	model.addAttribute("books", books);
    	return "/books/index.jsp";
    }
    
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
    	return "/books/newbook.jsp";
    }
    
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String createbook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	if(result.hasErrors()) {
    		return "/books/newbook.jsp";
    	}else {
    		bookService.createBook(book);
    		return "redirect:/books";
    	}
    }
    
    @RequestMapping("/books/{id}")
    public String showbook(@PathVariable("id") Long id, Model model) {
    	Book book = bookService.findBook(id);
    	if(book != null) {
    		model.addAttribute("book", book);
        	return "/books/showbook.jsp";
    	}
    	return null;
    }
    
    @RequestMapping("/books/{id}/edit")
    public String editbook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/editbook.jsp";
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String updatebook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "/books/editbook.jsp";
        } else {
            bookService.updateBook(id, book.getTitle(), book.getDescription(), book.getLanguage(), book.getNumberOfPages());
            return "redirect:/books";
        }
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String deletebook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}

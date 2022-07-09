package com.codingdojo.mvc.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
	 // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //update a book by id
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		Book book= optionalBook.get();
    		book.setTitle(title);
    		book.setDescription(desc);
    		book.setLanguage(lang);
    		book.setNumberOfPages(numOfPages);
    		book.setUpdatedAt(new Date());
    		return bookRepository.save(book);
    	}else {
    		return null;
    	}
    }
    
    //delete a book by id
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}

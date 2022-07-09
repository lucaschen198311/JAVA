package com.codingdojo.mvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.controllers.BooksController;

@SpringBootTest
public class BookModelTest {
	@Autowired
	private static Validator validator;
	private BooksController controller;
	@BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void contextLoads() {
    }
    @Test
    void testController() {
        assertThat(controller).isNull();
    }
    
    @Test
    void testBook() {
        Book book = new Book();
        book.setTitle("Harry Potter and the Goblet of Fire");
        book.setDescription("Great book");
        book.setLanguage("English");
        book.setNumberOfPages(734);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        for (ConstraintViolation<Book> violation : violations) {
            System.out.println(violation.getMessage()); 
        }
        assertTrue(violations.isEmpty());
    }
    
    @Test
    void assumeTitleIsNull() {
        Book book = new Book();
        book.setDescription("Great Book");
        book.setLanguage("English");
        book.setNumberOfPages(734);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertFalse(violations.isEmpty());
    }
}

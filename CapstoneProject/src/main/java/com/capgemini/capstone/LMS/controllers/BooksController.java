package com.capgemini.capstone.LMS.controllers;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstone.LMS.entities.Book;

import com.capgemini.capstone.LMS.services.BookServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BooksController {
	

	private BookServices bookServices; 
	
	@Autowired
	public BooksController(BookServices bookServices) {
		// TODO Auto-generated constructor stub
		this.bookServices = bookServices;
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks()
	{
		return ResponseEntity.status(HttpStatus.OK).body(bookServices.findAllBooks());
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book)
	{
		return ResponseEntity.status(201).body(bookServices.createBook(book));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book book ) {
		return ResponseEntity.status(200).body(bookServices.updateBookById(id, book));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findBookById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(bookServices.findBookById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBookById(@PathVariable Long id) {
		System.out.println("we are checking");
		return ResponseEntity.status(204).body(bookServices.deleteBookById(id));
	}
	
	
	
	
	
	
	
	
	
	
	
}

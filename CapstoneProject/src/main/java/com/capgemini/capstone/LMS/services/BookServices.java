package com.capgemini.capstone.LMS.services;

import java.util.List;

import com.capgemini.capstone.LMS.entities.Book;



public interface BookServices {

	public Book createBook(Book book);
	public Book updateBookById(Long id, Book book );
	public Book findBookById(Long id);
	public Boolean deleteBookById(Long id);
	public List<Book> findAllBooks();
}

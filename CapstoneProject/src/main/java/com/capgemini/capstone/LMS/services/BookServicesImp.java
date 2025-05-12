package com.capgemini.capstone.LMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstone.LMS.entities.Book;
import com.capgemini.capstone.LMS.repositories.BookRepository;


@Service
public class BookServicesImp implements BookServices{

	private BookRepository bookRepository;
	
	@Autowired
	public BookServicesImp(BookRepository bookRepository) {
		// TODO Auto-generated constructor stub
		this.bookRepository =bookRepository;
		
	}
	
	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}



	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book updateBookById( Long id ,Book b) {
		// TODO Auto-generated method stub
		Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book with this id not found "+id));
		book.setImgSrc(b.getImgSrc());
		book.setTitle(b.getTitle());
		book.setGenre(b.getGenre());
		book.setAvailableCopies(b.getAvailableCopies());
		book.setTotalCopies(b.getTotalCopies());
		book.setAuthorId(b.getAuthorId());
		return bookRepository.save(book);
	}

	@Override
	public Book findBookById(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book with this id not found "+id));
	}

	@Override
	public Boolean deleteBookById(Long id) {
		// TODO Auto-generated method stub
		Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book with this id not found "+id));
		bookRepository.delete(book);
		return true;
	}

}

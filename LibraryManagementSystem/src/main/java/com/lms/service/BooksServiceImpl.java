package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.exception.BooksException;
import com.lms.model.Books;
import com.lms.repository.BooksRepo;


@Service
public class BooksServiceImpl implements BooksService{
	
	@Autowired
	private BooksRepo br;
	
	@Override
	public Books addBooks(Books book) throws BooksException {
		Books b=br.save(book);
		if(b!=null)
			return b;
		else throw new BooksException("Book not saved");
	}

}

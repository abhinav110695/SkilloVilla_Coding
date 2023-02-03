package com.lms.service;

import com.lms.exception.BooksException;
import com.lms.model.Books;

public interface BooksService {
	
	public Books addBooks(Books book) throws BooksException;
}

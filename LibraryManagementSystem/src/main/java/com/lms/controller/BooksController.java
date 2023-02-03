package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.exception.BooksException;
import com.lms.model.Books;
import com.lms.service.BooksService;

@RestController
@RequestMapping("/lms")
public class BooksController {
	
	@Autowired
	private BooksService bs;
	
	@PostMapping("/savebook")
	public ResponseEntity<Books> savebook(@RequestBody Books book) throws BooksException{
		return new ResponseEntity<Books>(bs.addBooks(book), HttpStatus.CREATED);
	}
}

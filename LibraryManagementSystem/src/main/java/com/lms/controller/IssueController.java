package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.exception.IssueException;
import com.lms.model.Books;
import com.lms.model.Issue;
import com.lms.service.BooksService;
import com.lms.service.IssueService;

@RequestMapping("/lms")
@RestController
public class IssueController {
	
	@Autowired
	private BooksService bs;
	
	@Autowired
	private IssueService is;
	
	@PostMapping("/checkout")
	public ResponseEntity<Issue> checkout(@RequestBody Issue issue,Integer bookId,Integer userId) throws IssueException{
		
		return new ResponseEntity<Issue>(is.addIssue(issue, bookId, userId),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Issue>> viewAllIssues() throws IssueException{
		return new ResponseEntity<List<Issue>>(is.viewIssue(), HttpStatus.OK);
	}
	
	@DeleteMapping("/return/{id}")
	public ResponseEntity<Issue> returnBook(@PathVariable("id") Integer issueId) throws IssueException{
		return new ResponseEntity<Issue>(is.delIssue(issueId), HttpStatus.OK);
	}
}

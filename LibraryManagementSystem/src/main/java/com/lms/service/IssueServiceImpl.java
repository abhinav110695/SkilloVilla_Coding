package com.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.exception.IssueException;
import com.lms.model.Books;
import com.lms.model.Issue;
import com.lms.model.User;
import com.lms.repository.BooksRepo;
import com.lms.repository.IssueRepo;
import com.lms.repository.UserRepo;

@Service
public class IssueServiceImpl implements IssueService{
	
	@Autowired
	private IssueRepo ir;
	
	@Autowired
	private BooksRepo br;
	
	@Autowired
	private UserRepo ur;
	
	private int finePerDay = 5;
	
	private int maxBooks=5;
	
	
	@Override
	public Issue addIssue(Issue issue,Integer bookId,Integer userId) throws IssueException {
		
		List<Books> lb= new ArrayList<>();
		
		if(lb.size()<=maxBooks) {
			User u=new User();
			u=ur.findById(userId).get();
			
			Books b=new Books();
			b=br.findById(bookId).get();
			
			lb.add(b);
			
			if(issue!=null) {
				issue.setBook(lb);
				issue.setUser(u);
				return ir.save(issue);
			}
			else throw new IssueException("Issue not saved");
		}
		else throw new IssueException("Only 5 books maximum allowed");
		
	}



	@Override
	public List<Issue> viewIssue() throws IssueException {
		List<Issue> li=ir.findAll();
		return li;
	}



	@Override
	public Issue delIssue(Integer issueId) throws IssueException {
		Optional<Issue> optIssue=ir.findById(issueId);
		
		if(!optIssue.isEmpty()) {
			Issue i=optIssue.get();
			
			ir.delete(i);
		}
		return null;
		
	}
	
	
	
	

}

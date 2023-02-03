package com.lms.service;


import java.util.List;

import com.lms.exception.IssueException;
import com.lms.model.Issue;

public interface IssueService {
	
	public Issue addIssue(Issue issue,Integer bookId,Integer userId) throws IssueException;
	public List<Issue> viewIssue() throws IssueException;
	public Issue delIssue(Integer issueId) throws IssueException;
}

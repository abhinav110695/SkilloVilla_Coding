package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.model.Issue;

@Repository
public interface IssueRepo extends JpaRepository<Issue, Integer>{

}

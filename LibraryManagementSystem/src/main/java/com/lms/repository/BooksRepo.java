package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.model.Books;

@Repository
public interface BooksRepo extends JpaRepository<Books, Integer>{

}

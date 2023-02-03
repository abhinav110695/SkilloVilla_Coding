package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Books{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	
	@NotNull(message="Title cannot be null!")
	@Pattern(regexp = "[A-Za-z]")
	private String title;
	
	@NotNull(message="Author cannot be null!")
	@Pattern(regexp = "[A-Za-z]")
	private String author;
	
	@ManyToOne
	private Issue issue;
	
}

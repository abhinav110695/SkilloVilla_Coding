package com.lms.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer issueId;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate issueDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate returnDate;
	
	@JsonIgnore
	private Integer fine;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Books> book;
	
	@JsonIgnore
	@ManyToOne
	private User user;
}

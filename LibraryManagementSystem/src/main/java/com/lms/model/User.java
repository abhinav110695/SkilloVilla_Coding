package com.lms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotNull(message="userName cannot be null!")
	@Pattern(regexp = "[A-Za-z]")
	private String userName;
	
	@NotNull(message="Mobile number cannot be null!")
	@Pattern(regexp = "[0-9]", message = "Enter valid 10 digit mobile number")
	@Size(min = 10,max = 10)
	private String mobile;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Issue> issue;
	
}

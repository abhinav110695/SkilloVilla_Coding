package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.exception.UserException;
import com.lms.model.User;
import com.lms.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo ur;
	
	@Override
	public User addUser(User user) throws UserException {
		
			User u=ur.save(user);
			
			if(u!=null)
				return u;
			
			else throw new UserException("User not saved");
			
		
	}

}

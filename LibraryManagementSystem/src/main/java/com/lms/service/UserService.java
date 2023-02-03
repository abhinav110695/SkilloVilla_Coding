package com.lms.service;

import com.lms.exception.UserException;
import com.lms.model.User;

public interface UserService {
	public User addUser(User user) throws UserException;
}

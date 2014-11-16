package com.abroad.studies.service;

import java.security.NoSuchAlgorithmException;

import com.abroad.studies.model.User;

public interface UserService {	 
	    public void addUser(User p) throws NoSuchAlgorithmException;
	    public void updateUser(User p);
		public User getUserByActId(String actId);
		public User getUserByEmail(String email);
}

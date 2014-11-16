package com.abroad.studies.dao;

import com.abroad.studies.model.User;

public interface UserDAO {
	    public void addUser(User p);
	    public void updateUser(User p);
	    public User retrieveUserByEmail(String email);
		public User retrieveUserByActId(String actId);
}

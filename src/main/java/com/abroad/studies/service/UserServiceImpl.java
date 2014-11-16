package com.abroad.studies.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abroad.studies.model.User;
import com.abroad.studies.util.PasswordUtil;
import com.abroad.studies.dao.UserDAO; 

 
@Service
public class UserServiceImpl implements UserService {
     
    private UserDAO UserDAO;
 
    public void setUserDAO(UserDAO UserDAO) {
        this.UserDAO = UserDAO;
    }
 
    @Override
    public void addUser(User user) throws NoSuchAlgorithmException{
        this.UserDAO.addUser(user);
    }
 
    @Override
    public void updateUser(User p) {
        this.UserDAO.updateUser(p);
    }


	@Override
	public User getUserByActId(String actId) {
		return this.UserDAO.retrieveUserByActId(actId);
	}

	@Override
	public User getUserByEmail(String email) {
		return this.UserDAO.retrieveUserByEmail(email);
		
	}
 
}
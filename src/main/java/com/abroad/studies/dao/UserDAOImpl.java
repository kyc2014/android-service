package com.abroad.studies.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.transaction.annotation.Transactional;

import com.abroad.studies.model.User;
 
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addUser(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("User saved successfully, Person Details="+p);
    }
 
    @Override
    public void updateUser(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Person updated successfully, Person Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public User retrieveUserByActId(String actId) {
        Session session = this.sessionFactory.getCurrentSession();
        List user = session.createQuery("from User where actId =:actId").setParameter("actId",actId).list();
        User userModel = null;
        for(int i=0;i<user.size();i++){
        	userModel = (User)user.get(i);
        	break;
        }
        return userModel;
    }

	@Override
	public User retrieveUserByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		List user = session.createQuery("from User where email =:email").setParameter("email",email).list();
        User userModel = null;
        for(int i=0;i<user.size();i++){
        	userModel = (User)user.get(i);
        	break;
        }
        return userModel;
		
	}
 
}

package com.chatbox.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.chatbox.db.HibernateUtil;
import com.chatbox.entities.User;

public class UserDao {
	
	
	HibernateUtil hbUtil;
	
	
	public UserDao(HibernateUtil hbUtil) {
		super();
		this.hbUtil = hbUtil;
	}

	public boolean createUser(User user)
	{

        boolean status = false;
		SessionFactory factory = hbUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		String res =(String)session.save(user);
	
		if(res.equals(user.getUsername()))
		{
			status = true;
		}
		
		return status;
	}
	
	
	
	
	public User getUser(String username)
	{
		
		SessionFactory factory = hbUtil.getSessionFactory();
		Session session = factory.openSession();
		
		User user =session.get(User.class, username);
		
		return user;
		
	}
	
	
	
	
}

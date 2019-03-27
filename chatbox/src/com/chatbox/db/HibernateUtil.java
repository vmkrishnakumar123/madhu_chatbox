package com.chatbox.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public SessionFactory getSessionFactory()
	{
		SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		return factory;
	}

}

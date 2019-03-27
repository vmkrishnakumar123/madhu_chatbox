package com.chatbox.services;

import com.chatbox.dao.UserDao;
import com.chatbox.entities.User;

public class UserServices {

	UserDao dao;

	public UserServices(UserDao dao) {
		super();
		this.dao = dao;
	}
	
	
	
	
	public int  saveUser(User user)
	{
		int i=0;
		User user1=dao.getUser(user.getUsername());
		if(user1!=null)
		{
		i=1;	
		}
		else
		{
			boolean status=dao.createUser(user);
			
			if(status ==true)
			{
				i=2;
			}
		}
		
		return i;
	}
	
	
}

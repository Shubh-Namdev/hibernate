package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.dto.UserDetails;



public class Main {
	public static void main(String[] args) {		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user = session.get(UserDetails.class, 6);
		/*
		UserDetails user = new UserDetails();
		user.setId(3);
		user.setName("User 3");
		*/
		session.delete(user);
		
		session.getTransaction().commit();
		session.close();
		
	}
}

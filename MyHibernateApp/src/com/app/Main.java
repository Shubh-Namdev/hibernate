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
		//System.out.println("User name is "+user.getUserName());
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("User name is "+user.getUserName());
		
	}
}

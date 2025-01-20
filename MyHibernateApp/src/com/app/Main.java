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
		
		for (int i = 1; i <= 10; i++) {
			UserDetails user = new UserDetails();
			user.setName("User "+i);
			session.save(user);
		}
		
		session.getTransaction().commit();
		session.close();
		
	}
}

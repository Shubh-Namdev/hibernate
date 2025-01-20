package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.dto.UserDetails;



public class Main {
	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		user1.setName("User 1");
		UserDetails user2 = new UserDetails();
		user2.setName("User 2");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user1);
		session.save(user2);
		
		UserDetails user = session.get(UserDetails.class, 2);
	
		session.getTransaction().commit();
		session.close();
		
		
		//session 2
		user.setName("Updated user");
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(user);
		user.setName("Updated user after coming to persisten stage");
		
		session.getTransaction().commit();
		session.close();
		
	}
}

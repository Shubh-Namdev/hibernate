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
		UserDetails user = session.get(UserDetails.class, 1);
		//first level cache
		//UserDetails user2 = session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();
		
		//second session
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		UserDetails user2 = session2.get(UserDetails.class, 1);
		session2.getTransaction().commit();
		session2.close();
	}
}

package com.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.app.dto.UserDetails;


public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query<UserDetails> query = session.createQuery("from UserDetails", UserDetails.class);
		query.setFirstResult(3);
		query.setMaxResults(6);
		List<UserDetails> users = query.list();
	
		session.getTransaction().commit();
		session.close();
		
		System.out.println(users);
	}
}

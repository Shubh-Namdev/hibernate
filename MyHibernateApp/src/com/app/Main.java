package com.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.dto.UserDetails;

public class Main {
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setId(1);
		user.setName("Zomato");
		user.setAddress("Some address");
		user.setJoinedDate(new Date());
		user.setDescription("some description");
		
		UserDetails user2 = new UserDetails();
		user2.setName("Swiggy");
		user2.setAddress("Swiggy address");
		user2.setJoinedDate(new Date());
		user2.setDescription("swiggy description");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		/*
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		System.out.println("Address of the user is : "+user.getAddress());
		session.close();
		*/
	}
}

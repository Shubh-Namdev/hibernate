package com.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.dto.UserDetails;

public class Main {
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setId(3);
		user.setName("Zomato");
		user.setAddress("Some address");
		user.setJoinedDate(new Date());
		user.setDescription("some description");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
	}
}

package com.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.app.dto.UserDetails;


public class Main {
	public static void main(String[] args) {
		//String userId = "3 or 1=1";
		String userId = "2";
		String userName = "User 3";
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query<UserDetails> query = session.createQuery("from UserDetails where userId=:userId and userName=:userName", UserDetails.class);
		query.setParameter("userId", Integer.parseInt(userId));
		query.setParameter("userName", userName);
		List<UserDetails> users = query.list();
	
		session.getTransaction().commit();
		session.close();
		
		System.out.println(users);
	}
}

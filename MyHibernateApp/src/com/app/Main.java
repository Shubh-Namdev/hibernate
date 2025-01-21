package com.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.app.dto.UserDetails;


public class Main {
	public static void main(String[] args) {
		//String userId = "3 or 1=1";
		String userId = "2";
		String userName = "User 4";
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query<UserDetails> query1 = session.createNamedQuery("UserDetails.byId", UserDetails.class);
		query1.setParameter("userId", Integer.parseInt(userId));
		List<UserDetails> users = query1.list();
		
		Query<UserDetails> query2 = session.createNamedQuery("UserDetails.byName", UserDetails.class);
		query2.setParameter("username", userName);
		List<UserDetails> userss = query2.list();
	
		session.getTransaction().commit();
		session.close();
		
		System.out.println(users);
		System.out.println(userss);
	}
}

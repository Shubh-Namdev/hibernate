package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.dto.Address;
import com.app.dto.UserDetails;

public class Main {
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setId(1);
		user.setName("Zomato");
		
		Address address = new Address();
		address.setCity("Denmark");
		address.setState("New York");
		address.setPincode("67543");
		
		user.setHomeAddress(address);
		user.setOfficeAddress(address);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}
}

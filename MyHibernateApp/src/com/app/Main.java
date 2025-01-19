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
		
		Address address1 = new Address();
		address1.setCity("Denmark");
		address1.setState("New York");
		address1.setPincode("67543");
		
		Address address2 = new Address();
		address2.setCity("Denmark");
		address2.setState("New York");
		address2.setPincode("67543");
		
		Address address3 = new Address();
		address3.setCity("Denmark");
		address3.setState("New York");
		address3.setPincode("67543");
		
		user.getAddresses().add(address1);
		user.getAddresses().add(address2);
		user.getAddresses().add(address3);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		//GET
		user = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		//trying to elaborate the proxy class by closing the session
		session.close();
		System.out.println(user.getAddresses().size());
		
	}
}

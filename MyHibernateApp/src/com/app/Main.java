package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.dto.UserDetails;
import com.app.dto.Vehicle;

public class Main {
	public static void main(String[] args) {
		UserDetails shubh = new UserDetails();
		shubh.setName("Zomato");
		
		Vehicle car = new Vehicle();
		car.setVehicleName("Car");
		
		shubh.setVehicle(car);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(shubh);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		
	}
}

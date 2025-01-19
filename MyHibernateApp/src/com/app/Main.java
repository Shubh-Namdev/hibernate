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
		UserDetails shubham = new UserDetails();
		shubham.setName("Swiggy");
		
		Vehicle car = new Vehicle();
		car.setVehicleName("Car");
		Vehicle jeep = new Vehicle();
		jeep.setVehicleName("Jeep");
		
		shubh.getVehicles().add(car);
		shubh.getVehicles().add(jeep);
		
		car.getUsers().add(shubh);
		jeep.getUsers().add(shubham);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(shubh);
		session.save(shubham);
		session.save(car);
		session.save(jeep);
		session.getTransaction().commit();
		session.close();
		
	}
}

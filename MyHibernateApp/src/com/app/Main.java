package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.dto.FourWheeler;
import com.app.dto.TwoWheeler;
import com.app.dto.Vehicle;

public class Main {
	public static void main(String[] args) {		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Vehicle");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Yamaha FZ");
		bike.setHandle("Bike handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Magnite");
		car.setSteering("Power steering");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		
	}
}

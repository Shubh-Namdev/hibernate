package com.app.dto;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
	private String steering;

	public String getSteering() {
		return steering;
	}

	public void setSteering(String steering) {
		this.steering = steering;
	}
	
	
}

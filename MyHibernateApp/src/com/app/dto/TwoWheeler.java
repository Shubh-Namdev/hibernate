package com.app.dto;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {
	private String handle;

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	
}

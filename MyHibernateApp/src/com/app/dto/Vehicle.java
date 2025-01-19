package com.app.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	@Id @GeneratedValue
	@Column(name="vehicle_id")
	private int vehicleId;
	
	@Column(name="vehicle_name")
	private String vehicleName;
	
	@ManyToMany(mappedBy = "vehicles")
	private Collection<UserDetails> users = new ArrayList<UserDetails>();
	
	public Collection<UserDetails> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserDetails> users) {
		this.users = users;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}

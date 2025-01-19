package com.app.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table (name = "user_details")
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "user_id")
	private int userId;
	
	@Column (name = "user_name")
	private String userName;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="user_vehicle", joinColumns = @JoinColumn(name="user_id"), 
	                                inverseJoinColumns = @JoinColumn(name="vehicle_id"))
	@NotFound(action=NotFoundAction.IGNORE)
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setName(String userName) {
		this.userName = userName;
	}
	
	
}

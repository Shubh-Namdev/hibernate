package com.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Entity (name = "user_details")
@Entity
@Table (name = "user_details")
public class UserDetails {
	@Id
	@Column (name = "user_id")
	private int userId;
	
	@Column (name = "user_name")
	private String userName;
	
	private String address;
	
	@Transient
	@Column (name = "join_date")
    private Date joinedDate;
	private String description;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

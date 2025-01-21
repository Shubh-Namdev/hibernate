package com.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="UserDetails.byId", query = "from UserDetails where userId = :userId")
@NamedNativeQuery(name="UserDetails.byName", query="select * from user_details where user_name=:username", resultClass = UserDetails.class)
@Table(name="user_details")
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "user_id")
	private int userId;
	
	@Column (name = "user_name")
	private String userName;
		
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
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + "]";
	}
	
	
	
}

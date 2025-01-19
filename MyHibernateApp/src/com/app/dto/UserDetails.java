package com.app.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table (name = "user_details")
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "user_id")
	private int userId;
	
	@Column (name = "user_name")
	private String userName;
	
	@Embedded
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="user_address", joinColumns = @JoinColumn(name="user_id"))
	@GenericGenerator(name="increment-gen",strategy="increment")
    @CollectionId( columns = { @Column( name ="address_id") }, generator ="increment-gen", type =@Type( type ="long"))
	private Collection<Address> addresses = new ArrayList<Address>();
	

	public int getUserId() {
		return userId;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	public Collection<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}
	public String getUserName() {
		return userName;
	}
	public void setName(String userName) {
		this.userName = userName;
	}
	
	
}

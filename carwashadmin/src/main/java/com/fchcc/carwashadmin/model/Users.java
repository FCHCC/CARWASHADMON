package com.fchcc.carwashadmin.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Id;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQuery(name="Users.findAll", query="select u from Users u")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int Id;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String password;
	
	private String name;
	
	public Users() {}
	
	public Users(String userName, String password) {
		 
		  super();
		  this.userName = userName;
		  this.password = password;
		 }
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
		
		
}

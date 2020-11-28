package com.bassem.boot1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {

	@Id
	private String username;
	private String password;
	private int active;
	
	@ManyToMany
	List<Role> roles;
	
	

	public User() {
		super();
	}

	public User(String username, String password, int active) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
}

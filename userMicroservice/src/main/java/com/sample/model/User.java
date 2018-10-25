package com.sample.model;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.sample.model.support.IbSupport;

@Table(value = "users")
public class User extends IbSupport{
	
	@PrimaryKey
	private UUID id;
	
	private String userName;
	
	private String email;
	
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long createdAt, long updatedAt, boolean isDeleted) {
		super(createdAt, updatedAt, isDeleted);
		// TODO Auto-generated constructor stub
	}

	public User(UUID id, String userName, String email, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

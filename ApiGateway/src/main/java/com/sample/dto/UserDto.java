package com.sample.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.sample.model.support.IbSupport;

public class UserDto extends IbSupport{
	
	private UUID id;
	
	@NotNull(message="User name cannot be null")
	private String userName;
	
	@NotNull(message="User email cannot be null")
	private String email;
	
	@NotNull(message="User password cannot be null")
	private String password;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(long createdAt, long updatedAt, boolean isDeleted) {
		super(createdAt, updatedAt, isDeleted);
		// TODO Auto-generated constructor stub
	}

	public UserDto(UUID id, String userName, String email, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
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

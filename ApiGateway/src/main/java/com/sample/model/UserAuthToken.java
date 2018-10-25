package com.sample.model;

import java.util.List;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("user_token")
public class UserAuthToken {
	
	@PrimaryKey
	private String id;
	
	private List<String> tokens;
		
	public UserAuthToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getTokens() {
		return tokens;
	}

	public void setTokens(List<String> tokens) {
		this.tokens = tokens;
	}

	@Override
	public String toString() {
		return "UserAuthToken [id=" + id + ", tokens=" + tokens + "]";
	}

	public UserAuthToken(String id, List<String> tokens) {
		super();
		this.id = id;
		this.tokens = tokens;
	}
	
	
}

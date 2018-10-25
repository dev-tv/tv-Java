package com.sample.service;


public interface AuthTokenService {
	
	public void saveToken(String id, String token );
	public void addNewToken(String id, String token );
	public boolean verifieAccount(String id);
	public void removeToken(String id, String token);
}

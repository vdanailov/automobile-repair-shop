package com.example.frontendapp.models;

import java.util.Properties;

public class JwtKeychain {
	private static JwtKeychain instance = null;
	
	public Properties keychain = new Properties();
	
	private JwtKeychain() {}
	
	public static JwtKeychain getInstance() {
		if(instance == null) {
			instance = new JwtKeychain();
		} 
		
		return instance;
	}
	
	public void add(String username, String token) {
		keychain.setProperty(username, token);
	}
	
	public String getToken(String username) {
		return "Bearer " + keychain.getProperty(username);
	}
	
	public void remove(String username) {
		keychain.remove(username);
	}
}

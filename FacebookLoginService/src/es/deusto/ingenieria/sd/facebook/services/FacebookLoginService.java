package es.deusto.ingenieria.sd.facebook.services;

import java.util.HashMap;
import java.util.Map;

public class FacebookLoginService{

	private Map<String, String> FacebookProfileMap = new HashMap<>();
	public static FacebookLoginService instance;
	
	public FacebookLoginService() {
		this.initializeData();
	}

	private void initializeData() {
		FacebookProfileMap.put("pepe@mail.es", "juan1234");
		FacebookProfileMap.put("jose@mail.es", "jose1234");
		FacebookProfileMap.put("juan@mail.es", "juan1234");
	}
	
	public static FacebookLoginService getInstance() {
		if (instance == null) {
			try {
				instance = new FacebookLoginService();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}

	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		if (FacebookProfileMap.get(email).equals(password)) {
			return true;
		}
		return false;
	}

	public void addProfile(String email, String password) {
		FacebookProfileMap.put(email, password);
	}

	public boolean register(String email, String password) {
		// TODO Auto-generated method stub
		addProfile(email, password);
		return true;
	}

	public Map<String, String> getFacebookProfileMap() {
		return FacebookProfileMap;
	}
	
	public boolean isRegistered(String email) {
		return FacebookProfileMap.containsKey(email);
	}

}

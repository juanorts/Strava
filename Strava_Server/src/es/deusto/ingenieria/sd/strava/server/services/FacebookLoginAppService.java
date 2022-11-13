package es.deusto.ingenieria.sd.strava.server.services;

import java.util.HashMap;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;

public class FacebookLoginAppService {
	// Instance for the Singleton Pattern
	private static FacebookLoginAppService instance;

	// For simulation purposes with "Facebook Profile Database"
	private Map<String, Profile> FacebookProfileMap = new HashMap<>();

	private FacebookLoginAppService() {
	}

	public static FacebookLoginAppService getInstance() {
		if (instance == null) {
			instance = new FacebookLoginAppService();
		}

		return instance;
	}

	public Profile login(String email, String password) {
		// TODO: Get User using DAO and check
		// TODO: Save and check profiles password hashed
		Profile profile = FacebookLoginAppService.getInstance().getFacebookProfileMap().get(email);

		// We check if password is null to simulate that we don't store the passwords
		// Since we set it null with the register
		if (profile.getEmail().equals(email) && profile.checkPassword(null)) {
			return profile;
		} else {
			return null;
		}
	}
	
	public Map<String, Profile> getFacebookProfileMap() {
		return FacebookProfileMap;
	}
	
	public void addProfile(String email, Profile profile) {
		this.FacebookProfileMap.put(email, profile);
	}
}

package es.deusto.ingenieria.sd.strava.server.services;

import java.util.HashMap;

import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;

public class FacebookLoginAppService {
	// Instance for the Singleton Pattern
	private static FacebookLoginAppService instance;

	// For simulation purposes with "Google Profile Database"
	public static HashMap<String, Profile> FacebookProfileMap = new HashMap<>();

	private FacebookLoginAppService() { }

	public static FacebookLoginAppService getInstance() {
		if (instance == null) {
			instance = new FacebookLoginAppService();
		}

		return instance;
	}

	public Profile login(String email, String password) {
		// TODO: Get User using DAO and check
		// TODO: Save and check profiles password hashed
		Profile profile = FacebookLoginAppService.FacebookProfileMap.get(email);

		if (profile.getEmail().equals(email) && profile.checkPassword(password)) {
			return profile;
		} else {
			return null;
		}
	}
}

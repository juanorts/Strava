package es.deusto.ingenieria.sd.strava.server.services;

import java.util.HashMap;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;

public class GoogleLoginAppService {
	// Instance for the Singleton Pattern
	private static GoogleLoginAppService instance;

	// For simulation purposes with "Google Profile Database"
	public static Map<String, Profile> GoogleProfileMap = new HashMap<>();

	private GoogleLoginAppService() {
	}

	public static GoogleLoginAppService getInstance() {
		if (instance == null) {
			instance = new GoogleLoginAppService();
		}

		return instance;
	}

	public Profile login(String email, String password) {
		// TODO: Get User using DAO and check
		// TODO: Save and check profiles password hashed
		Profile profile = GoogleLoginAppService.GoogleProfileMap.get(email);

		if (profile.getEmail().equals(email) && profile.checkPassword(password)) {
			return profile;
		} else {
			return null;
		}
	}
}

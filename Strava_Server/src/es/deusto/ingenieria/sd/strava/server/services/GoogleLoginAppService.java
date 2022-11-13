package es.deusto.ingenieria.sd.strava.server.services;

import java.util.HashMap;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;

public class GoogleLoginAppService {
	// Instance for the Singleton Pattern
	private static GoogleLoginAppService instance;

	// For simulation purposes with "Google Profile Database"
	private Map<String, Profile> GoogleProfileMap = new HashMap<>();

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
		Profile profile = GoogleLoginAppService.getInstance().getGoogleProfileMap().get(email);

		// We check if password is null to simulate that we don't store the passwords
		// Since we set it null with the register
		if (profile.getEmail().equals(email) && profile.checkPassword(null)) {
			return profile;
		} else {
			return null;
		}
	}
	public Map<String, Profile> getGoogleProfileMap() {
		return GoogleProfileMap;
	}
	
	public void addProfile(String email, Profile profile) {
		this.GoogleProfileMap.put(email, profile);
	}
}

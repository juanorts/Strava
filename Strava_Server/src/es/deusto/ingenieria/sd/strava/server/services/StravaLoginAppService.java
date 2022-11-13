package es.deusto.ingenieria.sd.strava.server.services;

import java.util.HashMap;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;

public class StravaLoginAppService {
	// Instance for the Singleton Pattern
	private static StravaLoginAppService instance;

	private StravaLoginAppService() {
	}

	// For simulation purposes with "Strava Profile Database"
	private Map<String, Profile> StravaProfileMap = new HashMap<>();
		
	public static StravaLoginAppService getInstance() {
		if (instance == null) {
			instance = new StravaLoginAppService();
		}

		return instance;
	}

	public Profile login(String email, String password) {
		// TODO: Get User using DAO and check
		// TODO: Save and check profiles password hashed
		Profile profile = StravaLoginAppService.getInstance().getStravaProfileMap().get(email);

		if (profile.getEmail().equals(email) && profile.checkPassword(password)) {
			return profile;
		} else {
			return null;
		}
	}
	
	public Map<String, Profile> getStravaProfileMap() {
		return StravaProfileMap;
	}
	
	public void addProfile(String email, Profile profile) {
		this.StravaProfileMap.put(email, profile);
	}
}

package es.deusto.ingenieria.sd.strava.server.services;
import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;

public class StravaLoginAppService {
	// Instance for the Singleton Pattern
	private static StravaLoginAppService instance;

	private StravaLoginAppService() {
	}

	public static StravaLoginAppService getInstance() {
		if (instance == null) {
			instance = new StravaLoginAppService();
		}

		return instance;
	}

	public Profile login(String email, String password) {
		// TODO: Get User using DAO and check
		// TODO: Save and check profiles password hashed
		Profile profile = Profile.profilesMap.get(email);

		if (profile.getEmail().equals(email) && profile.checkPassword(password)) {
			return profile;
		} else {
			return null;
		}
	}
}

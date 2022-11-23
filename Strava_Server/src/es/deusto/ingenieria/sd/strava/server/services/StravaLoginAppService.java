package es.deusto.ingenieria.sd.strava.server.services;

import java.util.HashMap;
import java.util.Map;

public class StravaLoginAppService {
	// Instance for the Singleton Pattern
	private static StravaLoginAppService instance;

	private StravaLoginAppService() {
		this.initializeData();
	}

	@SuppressWarnings("deprecation")
	private void initializeData() {

		StravaProfileMap.put("marcelo@mail.es", "marcelo1234");
		StravaProfileMap.put("luis@mail.es", "luis1234");
		StravaProfileMap.put("ibai@mail.es", "ibai1234");

	}

	// For simulation purposes with "Strava Profile Database"
	private Map<String, String> StravaProfileMap = new HashMap<>();

	public static StravaLoginAppService getInstance() {
		if (instance == null) {
			instance = new StravaLoginAppService();
		}

		return instance;
	}

	public boolean login(String email, String password) {
		// TODO: Get User using DAO and check
		// TODO: Save and check profiles password hashed
		if (StravaLoginAppService.getInstance().StravaProfileMap.get(email).equals(password)) {
			return true;
		}
		return false;
	}

	public void addProfile(String email, String password) {
		StravaLoginAppService.getInstance().StravaProfileMap.put(email, password);
	}

	public boolean register(String email, String password) {
		// TODO Auto-generated method stub
		StravaLoginAppService.getInstance().StravaProfileMap.put(email, password);
		return true;
	}

	public Map<String, String> getStravaProfileMap() {
		return StravaProfileMap;
	}
}

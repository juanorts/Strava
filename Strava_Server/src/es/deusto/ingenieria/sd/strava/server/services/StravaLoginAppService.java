package es.deusto.ingenieria.sd.strava.server.services;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;
import es.deusto.ingenieria.sd.strava.server.data.domain.ProfileType;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sport;
import es.deusto.ingenieria.sd.strava.server.data.domain.TrainingSession;

public class StravaLoginAppService {
	// Instance for the Singleton Pattern
	private static StravaLoginAppService instance;

	private StravaLoginAppService() {
		this.initializeData();
	}
	
	@SuppressWarnings("deprecation")
	private void initializeData() {
		
		Date d7 = new Date(1999, 5, 12);
		Date d8 = new Date(2007, 7, 4);
		Date d9 = new Date(1945, 8, 3);
		
		Date cc2 = new Date(2022, 2, 1);
		Date cc3 = new Date(2022, 3, 1);
		Date cc4 = new Date(2022, 5, 1);
		
		Date cc7 = new Date(2022, 8, 1);
		Date cc8 = new Date(2022, 9, 1);
		Date cc9 = new Date(2022, 10, 1);
		
		
		Profile p7 = new Profile("marcelo@mail.es", "marcelo1234", "Marcelo", d7, 86.6f, 201, 183, 78, ProfileType.STRAVA);
		Profile p8 = new Profile("luis@mail.es", "luis1234", "Luis", d8, 81.6f, 179, 180, 88, ProfileType.STRAVA);
		Profile p9 = new Profile("ibai@mail.es", "ibai1234", "Ibai", d9, 67.6f, 172, 173, 59, ProfileType.STRAVA);
		
		Challenge c7 = new Challenge("Running and Cycling 250",cc7,cc8,250,600,Sport.BOTH);
		Challenge c8 = new Challenge("Running and Cycling 150",cc8,cc9,150,400,Sport.BOTH);
		Challenge c9 = new Challenge("Running and Cycling 350",cc7,cc9,350,800,Sport.BOTH);
		
		LocalTime tt1 = LocalTime.NOON;
		LocalTime tt2 = LocalTime.now();
		LocalTime tt3 = LocalTime.of(10, 40);
		
		TrainingSession t7 = new TrainingSession("Day1",Sport.RUNNING,15.0f,40,cc2,tt1);
		TrainingSession t8 = new TrainingSession("Day1",Sport.RUNNING,15.0f,50,cc3,tt2);
		TrainingSession t9 = new TrainingSession("Day1",Sport.RUNNING,30.0f,120,cc4,tt3);
		
		p7.addChallenge(c7);
		p8.addChallenge(c8);
		p9.addChallenge(c9);
		
		p7.addTrainingSession(t7);
		p8.addTrainingSession(t8);
		p9.addTrainingSession(t9);
		
		this.addProfile(p7.getEmail(), p7);
		this.addProfile(p8.getEmail(), p8);
		this.addProfile(p9.getEmail(), p9);
		
		
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

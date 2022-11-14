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

public class GoogleLoginAppService {
	// Instance for the Singleton Pattern
	private static GoogleLoginAppService instance;

	// For simulation purposes with "Google Profile Database"
	private Map<String, Profile> GoogleProfileMap = new HashMap<>();

	private GoogleLoginAppService() {
		this.initializeData();
	}
	
	@SuppressWarnings("deprecation")
	private void initializeData() {

		Date d4 = new Date(1999, 9, 8);
		Date d5 = new Date(1987, 3, 7);
		Date d6 = new Date(1965, 6, 6);
		
		Date cc1 = new Date(2022, 1, 1);
		Date cc2 = new Date(2022, 2, 1);
		Date cc4 = new Date(2022, 5, 1);
		Date cc5 = new Date(2022, 6, 1);
		Date cc6 = new Date(2022, 7, 1);
		
		Profile p4 = new Profile("mikel@mail.es", "mikel1234", "Mikel", d4, 55.6f, 188, 170, 76, ProfileType.GOOGLE);
		Profile p5 = new Profile("alvaro@mail.es", "alvaro1234", "Alvaro", d5, 95.6f, 177, 160, 100, ProfileType.GOOGLE);
		Profile p6 = new Profile("andoni@mail.es", "andoni1234", "Andoni", d6, 74.6f, 198, 175, 89, ProfileType.GOOGLE);
		
		Challenge c4 = new Challenge("Cycling 100KM",cc4,cc5,100,150,Sport.CYCLING);
		Challenge c5 = new Challenge("Cycling 150KM",cc5,cc6,150,250,Sport.CYCLING);
		Challenge c6 = new Challenge("Cycling 200KM",cc4,cc6,200,400,Sport.CYCLING);
		
		LocalTime tt1 = LocalTime.NOON;
		LocalTime tt2 = LocalTime.now();
		LocalTime tt3 = LocalTime.of(10, 40);
		
		TrainingSession t4 = new TrainingSession("Day1",Sport.CYCLING,20.0f,45,cc2,tt1);
		TrainingSession t5 = new TrainingSession("Day1",Sport.CYCLING,35.0f,45,cc1,tt2);
		TrainingSession t6 = new TrainingSession("Day1",Sport.CYCLING,69.0f,90,cc2,tt3);
		
		p4.addChallenge(c4);
		p5.addChallenge(c5);
		p6.addChallenge(c6);
		
		p4.addTrainingSession(t4);
		p5.addTrainingSession(t5);
		p6.addTrainingSession(t6);
		
		this.addProfile(p4.getEmail(), p4);
		this.addProfile(p5.getEmail(), p5);
		this.addProfile(p6.getEmail(), p6);
		
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

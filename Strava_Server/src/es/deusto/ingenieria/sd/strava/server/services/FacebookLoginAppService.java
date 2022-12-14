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

public class FacebookLoginAppService {
	// Instance for the Singleton Pattern
	private static FacebookLoginAppService instance;

	// For simulation purposes with "Facebook Profile Database"
	private Map<String, Profile> FacebookProfileMap = new HashMap<>();

	private FacebookLoginAppService(){
		this.initializeData();

	}
	@SuppressWarnings("deprecation")
	private void initializeData(){
		
		Date d1 = new Date(2002, 11, 11);
		Date d2 = new Date(2008, 10, 10);
		Date d3 = new Date(2001, 10, 9);
		
		Date cc1 = new Date(2022, 1, 1);
		Date cc2 = new Date(2022, 2, 1);
		Date cc3 = new Date(2022, 3, 1);
		
		Profile p1 = new Profile("pepe@mail.es", "pepe1234", "Pepe", d1, 80.6f, 179, 190, 80, ProfileType.FACEBOOK);
		Profile p2 = new Profile("jose@mail.es", "jose1234", "Jose", d2, 90.6f, 180, 188, 60, ProfileType.FACEBOOK);
		Profile p3 = new Profile("juan@mail.es", "juan1234", "Juan", d3, 100.6f, 169, 181, 70, ProfileType.FACEBOOK);
		
		Challenge c1 = new Challenge("Running 50Km",cc1,cc2,50,300,Sport.RUNNING);
		Challenge c2 = new Challenge("Running 100Km",cc2,cc3,100,500,Sport.RUNNING);
		Challenge c3 = new Challenge("Running 150KM",cc1,cc3,150,800,Sport.RUNNING);
		
		LocalTime tt1 = LocalTime.NOON;
		LocalTime tt2 = LocalTime.now();
		LocalTime tt3 = LocalTime.of(10, 40);
		
		TrainingSession t1 = new TrainingSession("Day1",Sport.BOTH,20.0f,60,cc1,tt1);
		TrainingSession t2 = new TrainingSession("Day1",Sport.BOTH,30.0f,90,cc2,tt2);
		TrainingSession t3 = new TrainingSession("Day1",Sport.BOTH,40.0f,90,cc1,tt3);
		
		p1.addChallenge(c1);
		p2.addChallenge(c2);
		p3.addChallenge(c3);
		
		p1.addTrainingSession(t1);
		p2.addTrainingSession(t2);
		p3.addTrainingSession(t3);
		
		this.addProfile(p1.getEmail(), p1);
		this.addProfile(p2.getEmail(), p2);
		this.addProfile(p3.getEmail(), p3);
	}

	public static FacebookLoginAppService getInstance(){
		if (instance == null) {
			instance = new FacebookLoginAppService();
		}

		return instance;
	}

	public Profile login(String email, String password){
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

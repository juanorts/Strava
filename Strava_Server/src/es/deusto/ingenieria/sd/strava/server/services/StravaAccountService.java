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
import es.deusto.ingenieria.sd.strava.server.gateway.GoogleLoginServiceGateway;

public class StravaAccountService {
	// Instance for the Singleton Pattern
	private static StravaAccountService instance;

	private StravaAccountService() {
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

		Profile p7 = new Profile("marcelo@mail.es", "marcelo1234", "Marcelo", d7, 86.6f, 201, 183, 78,
				ProfileType.STRAVA);
		Profile p8 = new Profile("luis@mail.es", "luis1234", "Luis", d8, 81.6f, 179, 180, 88, ProfileType.STRAVA);
		Profile p9 = new Profile("ibai@mail.es", "ibai1234", "Ibai", d9, 67.6f, 172, 173, 59, ProfileType.STRAVA);

		Challenge c7 = new Challenge("Running and Cycling 250", cc7, cc8, 250, 600, Sport.BOTH);
		Challenge c8 = new Challenge("Running and Cycling 150", cc8, cc9, 150, 400, Sport.BOTH);
		Challenge c9 = new Challenge("Running and Cycling 350", cc7, cc9, 350, 800, Sport.BOTH);

		LocalTime tt1 = LocalTime.NOON;
		LocalTime tt2 = LocalTime.now();
		LocalTime tt3 = LocalTime.of(10, 40);

		TrainingSession t7 = new TrainingSession("Day1", Sport.RUNNING, 15.0f, 40, cc2, tt1);
		TrainingSession t8 = new TrainingSession("Day1", Sport.RUNNING, 15.0f, 50, cc3, tt2);
		TrainingSession t9 = new TrainingSession("Day1", Sport.RUNNING, 30.0f, 120, cc4, tt3);

		p7.addChallenge(c7);
		p8.addChallenge(c8);
		p9.addChallenge(c9);

		p7.addTrainingSession(t7);
		p8.addTrainingSession(t8);
		p9.addTrainingSession(t9);

		this.addProfile(p7.getEmail(), p7);
		this.addProfile(p8.getEmail(), p8);
		this.addProfile(p9.getEmail(), p9);

		Date d4 = new Date(1999, 9, 8);
		Date d5 = new Date(1987, 3, 7);
		Date d6 = new Date(1965, 6, 6);

		Date cc1 = new Date(2022, 1, 1);
		Date cc5 = new Date(2022, 6, 1);
		Date cc6 = new Date(2022, 7, 1);

		Profile p4 = new Profile("mikel@mail.es", "mikel1234", "Mikel", d4, 55.6f, 188, 170, 76, ProfileType.GOOGLE);
		Profile p5 = new Profile("alvaro@mail.es", "alvaro1234", "Alvaro", d5, 95.6f, 177, 160, 100,
				ProfileType.GOOGLE);
		Profile p6 = new Profile("andoni@mail.es", "andoni1234", "Andoni", d6, 74.6f, 198, 175, 89, ProfileType.GOOGLE);

		Challenge c4 = new Challenge("Cycling 100KM", cc4, cc5, 100, 150, Sport.CYCLING);
		Challenge c5 = new Challenge("Cycling 150KM", cc5, cc6, 150, 250, Sport.CYCLING);
		Challenge c6 = new Challenge("Cycling 200KM", cc4, cc6, 200, 400, Sport.CYCLING);

		TrainingSession t4 = new TrainingSession("Day1", Sport.CYCLING, 20.0f, 45, cc2, tt1);
		TrainingSession t5 = new TrainingSession("Day1", Sport.CYCLING, 35.0f, 45, cc1, tt2);
		TrainingSession t6 = new TrainingSession("Day1", Sport.CYCLING, 69.0f, 90, cc2, tt3);

		p4.addChallenge(c4);
		p5.addChallenge(c5);
		p6.addChallenge(c6);

		p4.addTrainingSession(t4);
		p5.addTrainingSession(t5);
		p6.addTrainingSession(t6);

		this.addProfile(p4.getEmail(), p4);
		this.addProfile(p5.getEmail(), p5);
		this.addProfile(p6.getEmail(), p6);

		Date d1 = new Date(2002, 11, 11);
		Date d2 = new Date(2008, 10, 10);
		Date d3 = new Date(2001, 10, 9);

		Profile p1 = new Profile("pepe@mail.es", "pepe1234", "Pepe", d1, 80.6f, 179, 190, 80, ProfileType.FACEBOOK);
		Profile p2 = new Profile("jose@mail.es", "jose1234", "Jose", d2, 90.6f, 180, 188, 60, ProfileType.FACEBOOK);
		Profile p3 = new Profile("juan@mail.es", "juan1234", "Juan", d3, 100.6f, 169, 181, 70, ProfileType.FACEBOOK);

		Challenge c1 = new Challenge("Running 50Km", cc1, cc2, 50, 300, Sport.RUNNING);
		Challenge c2 = new Challenge("Running 100Km", cc2, cc3, 100, 500, Sport.RUNNING);
		Challenge c3 = new Challenge("Running 150KM", cc1, cc3, 150, 800, Sport.RUNNING);

		TrainingSession t1 = new TrainingSession("Day1", Sport.BOTH, 20.0f, 60, cc1, tt1);
		TrainingSession t2 = new TrainingSession("Day1", Sport.BOTH, 30.0f, 90, cc2, tt2);
		TrainingSession t3 = new TrainingSession("Day1", Sport.BOTH, 40.0f, 90, cc1, tt3);

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

	// Contains all the Profiles of the users that have registered in the app
	private Map<String, Profile> GeneralProfileMap = new HashMap<>();

	public static StravaAccountService getInstance() {
		if (instance == null) {
			instance = new StravaAccountService();
		}

		return instance;
	}

	public Profile login(String email, String password, String profileType) {
		// TODO: Get User using DAO and check
		// TODO: Save and check profiles password hashed
		boolean loginSuccess = false;
		if (profileType.equals("GOOGLE")) {
			loginSuccess = GoogleLoginServiceGateway.getInstance().login(email, password);
		} else if (profileType.equals("STRAVA")) {
			loginSuccess = StravaLoginAppService.getInstance().login(email, password);
		} else if (profileType.equals("FACEBOOK")) {

		}

		if (loginSuccess == true) {
			Profile profile = StravaAccountService.getInstance().getGeneralProfileMap().get(email);
			return profile;
		} else {
			return null;
		}
	}

	public boolean register(String email, String password, String name, Date birthDate, float weight, int height,
			int maxBpm, int restBpm, String profileType) {
		switch (profileType) {
		case "STRAVA":
			// In Strava Profiles we save the password in this server locally
			Profile profile = new Profile(email, password, name, birthDate, weight, height, maxBpm, restBpm,
					ProfileType.STRAVA);
			if (!StravaLoginAppService.getInstance().getStravaProfileMap().containsKey(email)) {
				StravaLoginAppService.getInstance().register(email, password);
				StravaAccountService.getInstance().GeneralProfileMap.put(email, profile);
				return true;
			} else {
				return false;
			}

		case "FACEBOOK":
			// In Facebook Profiles we don't save the password in this server locally
			/*
			 * Profile profile1 = new Profile(email, password, name, birthDate, weight,
			 * height, maxBpm, restBpm, ProfileType.FACEBOOK); profile1.setPassword(null);
			 * if
			 * (!FacebookLoginAppService.getInstance().getFacebookProfileMap().containsKey(
			 * email)) { FacebookLoginAppService.getInstance().addProfile(email, profile1);
			 * return true; } else { return false; }
			 */
			return false;
		case "GOOGLE":
			// In Google Profiles we don't save the password in this server locally
			Profile profile11 = new Profile(email, null, name, birthDate, weight, height, maxBpm, restBpm,
					ProfileType.GOOGLE);
			if (!GoogleLoginServiceGateway.getInstance().getGoogleProfileMap().containsKey(email)) {
				GoogleLoginServiceGateway.getInstance().register(email, password);
				StravaAccountService.getInstance().GeneralProfileMap.put(email, profile11);
				return true;
			} else {
				return false;
			}

		default:
			break;
		}
		return false;
	}

	public Map<String, Profile> getGeneralProfileMap() {
		return GeneralProfileMap;
	}

	public void addProfile(String email, Profile profile) {
		this.GeneralProfileMap.put(email, profile);
	}
}

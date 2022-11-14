package es.deusto.ingenieria.sd.strava.server.services;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import es.deusto.ingenieria.sd.strava.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sport;
import es.deusto.ingenieria.sd.strava.server.data.domain.TrainingSession;

public class StravaAppService {
	private static StravaAppService instance;

	private StravaAppService() {
	}

	public static StravaAppService getInstance() {
		if (instance == null) {
			instance = new StravaAppService();
		}

		return instance;
	}

	public boolean createChallenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime,
			String sport, Profile profile) {
		switch(sport) {
		case "RUNNING":
			Challenge challenge = new Challenge(name, startDate, endDate, targetDistance, targetTime, Sport.RUNNING);
			profile.addChallenge(challenge);
			return true;
		case "CYCLING":
			Challenge challenge1 = new Challenge(name, startDate, endDate, targetDistance, targetTime, Sport.RUNNING);
			profile.addChallenge(challenge1);
			return true;
		case "BOTH":
			Challenge challenge2 = new Challenge(name, startDate, endDate, targetDistance, targetTime, Sport.RUNNING);
			profile.addChallenge(challenge2);
			return true;
		default:
			break;
		}
		return false;
	}

	public boolean createTrainingSession(String title, String sport, float distance, Date startDate, int duration,
			LocalTime startTime, Profile profile) {

		switch(sport) {
		case "RUNNING":
			TrainingSession trainingSession = new TrainingSession(title, Sport.RUNNING, distance, duration, startDate, startTime);
			profile.addTrainingSession(trainingSession);
			return true;
		case "CYCLING":
			TrainingSession trainingSession1 = new TrainingSession(title, Sport.CYCLING, distance, duration, startDate, startTime);
			profile.addTrainingSession(trainingSession1);
			return true;
		case "BOTH":
			TrainingSession trainingSession2 = new TrainingSession(title, Sport.BOTH, distance, duration, startDate, startTime);
			profile.addTrainingSession(trainingSession2);
			return true;
		default:
			break;
		}
		return false;
	}

	public List<TrainingSession> getSportTrainingSessions(String sport) {
		List<TrainingSession> trainingSessions = new ArrayList<>();
		for (Profile profile : StravaAppService.getInstance().retrieveProfiles()) {
			if (!profile.getCreatedTrainingSessions().isEmpty()) {
				for (TrainingSession trainingSession : profile.getCreatedTrainingSessions()) {
					if (trainingSession.getSport().name().equals(sport)) {
						trainingSessions.add(trainingSession);
					}
				}
			}
		}
		return trainingSessions;
	}

	public List<Challenge> getActiveChallenges() {
		List<Challenge> Active = new ArrayList<Challenge>();

		for (Profile profile : StravaAppService.getInstance().retrieveProfiles()) {
			for (Challenge c : profile.getSetUpChallenges()) {
				if (c.isActive()) {
					Active.add(c);
				}
			}
		}
		return Active;
	}

	public void acceptChallenge(Profile p, Challenge c) {
		p.addChallenge(c);
	}

	// Auxiliary method to gather all the profiles in the AppServices, due to no DAO
	public List<Profile> retrieveProfiles() {
		List<Profile> profileList = new ArrayList<>();
		for (Profile profile : StravaLoginAppService.getInstance().getStravaProfileMap().values()) {
			profileList.add(profile);
		}
		for (Profile profile : FacebookLoginAppService.getInstance().getFacebookProfileMap().values()) {
			profileList.add(profile);
		}
		for (Profile profile : GoogleLoginAppService.getInstance().getGoogleProfileMap().values()) {
			profileList.add(profile);
		}

		return profileList;
	}
}

package es.deusto.ingenieria.sd.strava.server.services;

import java.rmi.RemoteException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;
import es.deusto.ingenieria.sd.strava.server.data.domain.ProfileType;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sport;
import es.deusto.ingenieria.sd.strava.server.data.domain.TrainingSession;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionAssembler;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionDTO;
import es.deusto.ingenieria.sd.strava.server.services.FacebookLoginAppService;
import es.deusto.ingenieria.sd.strava.server.services.GoogleLoginAppService;
import es.deusto.ingenieria.sd.strava.server.services.StravaLoginAppService;

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
			Sport sport, Timestamp token, Profile profile) {

		Challenge challenge = new Challenge(name, startDate, endDate, targetDistance, targetTime, sport);
		profile.addChallenge(challenge);
		return true;
	}

	public boolean createTrainingSession(String title, Sport sport, float distance, Date startDate, int duration,
			Time startTime, Profile profile) {

		TrainingSession trainingSession = new TrainingSession(title, sport, distance, duration, startDate, startTime);
		profile.addTrainingSession(trainingSession);
		return true;
	}

	public List<TrainingSession> getSportTrainingSessions(Sport sport) {
		List<TrainingSession> trainingSessions = new ArrayList<>();
		for (Profile profile : StravaAppService.getInstance().retrieveProfiles()) {
			if (!profile.getCreatedTrainingSessions().isEmpty()) {
				for (TrainingSession trainingSession : profile.getCreatedTrainingSessions()) {
					if (trainingSession.getSport().equals(sport)) {
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

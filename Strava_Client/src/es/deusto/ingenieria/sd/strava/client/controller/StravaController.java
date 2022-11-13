package es.deusto.ingenieria.sd.strava.client.controller;
import java.sql.Date;
import java.time.LocalTime;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.server.data.*;

public class StravaController {
	private ServiceLocator serviceLocator;
	
	public StravaController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	private boolean createChallenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime, Sport sport){
		return this.serviceLocator.getService().createChallenge(name, startDate, endDate, targetDistance, targetTime, sport);
	}
	private boolean createTrainingSession(String title, Sport sport, float distance, Date startDate, int duration, LocalTime startTime) {
		return this.serviceLocator.getService().createTrainingSession(title, sport, distance, startDate, duration, startTime);
	}
	private List<TrainingSessionDTO> getSportTrainingSessions(String sport){
		return this.serviceLocator.getService().getSportTrainingSessions(sport);
	}
	private List<ChallengeDTO> getActiveChallenges(){
		return this.serviceLocator.getService().getActiveChallenges();
	}
	private boolean acceptChallenge(String name) {
		return this.serviceLocator.getService().acceptChallenge(name);
	}
	
	

}

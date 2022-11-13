package es.deusto.ingenieria.sd.strava.client.controller;
import java.rmi.RemoteException;
import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionDTO;

public class StravaController {
	private ServiceLocator serviceLocator;
	
	public StravaController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	public boolean createChallenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime, String sport) throws RemoteException{
		return this.serviceLocator.getService().createChallenge(name, startDate, endDate, targetDistance, targetTime, sport, LoginController.token);
	}
	public boolean createTrainingSession(String title, String sport, float distance, Date startDate, int duration, LocalTime startTime) throws RemoteException {
		return this.serviceLocator.getService().createTrainingSession(title, sport, distance, startDate, duration, startTime, LoginController.token);
	}
	public List<TrainingSessionDTO> getSportTrainingSessions(String sport) throws RemoteException{
		return this.serviceLocator.getService().getSportTrainingSessions(sport, LoginController.token);
	}
	public List<ChallengeDTO> getActiveChallenges() throws RemoteException{
		return this.serviceLocator.getService().getActiveChallenges(LoginController.token);
	}
	public boolean acceptChallenge(String name) throws RemoteException {
		return this.serviceLocator.getService().acceptChallenge(name, LoginController.token);
	}
	
	

}

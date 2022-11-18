package es.deusto.ingenieria.sd.strava.client.controller;
import java.rmi.RemoteException;
import java.util.Date;
import java.time.LocalTime;
import java.util.List;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.TrainingSessionDTO;

public class StravaController {
	
	private static StravaController instance;
	
	private StravaController() {
	}
	
	public static StravaController getInstance() {
		if (instance == null) {
			instance = new StravaController();
		}

		return instance;
	}
	
	public boolean createChallenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime, String sport) throws RemoteException{
		return ServiceLocator.getInstance().getService().createChallenge(name, startDate, endDate, targetDistance, targetTime, sport, LoginController.getInstance().getToken());
	}
	public boolean createTrainingSession(String title, String sport, float distance, Date startDate, int duration, LocalTime startTime) throws RemoteException {
		return ServiceLocator.getInstance().getService().createTrainingSession(title, sport, distance, startDate, duration, startTime, LoginController.getInstance().getToken());
	}
	public List<TrainingSessionDTO> getSportTrainingSessions(String sport) throws RemoteException{
		return ServiceLocator.getInstance().getService().getSportTrainingSessions(sport, LoginController.getInstance().getToken());
	}
	public List<ChallengeDTO> getActiveChallenges() throws RemoteException{
		return ServiceLocator.getInstance().getService().getActiveChallenges(LoginController.getInstance().getToken());
	}
	public boolean acceptChallenge(String name) throws RemoteException {
		return ServiceLocator.getInstance().getService().acceptChallenge(name, LoginController.getInstance().getToken());
	}
	
	

}

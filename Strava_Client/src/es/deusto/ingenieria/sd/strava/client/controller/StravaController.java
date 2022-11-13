package es.deusto.ingenieria.sd.strava.client.controller;
import java.sql.Date;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;

public class StravaController {
	private ServiceLocator serviceLocator;
	
	public StravaController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	private void createChallenge(String name, Date startDate, Date endDate, float targetDistance, int targetTime, String sport){
		this.serviceLocator.getService().createChallenge(name, startDate, endDate, targetDistance, targetTime, sport);
	}
	
	

}

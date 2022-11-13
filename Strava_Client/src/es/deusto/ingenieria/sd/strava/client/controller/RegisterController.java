package es.deusto.ingenieria.sd.strava.client.controller;

import java.sql.Date;
import java.time.LocalTime;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.server.data.*;

public class RegisterController {
	private ServiceLocator serviceLocator;
	
	public RegisterController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	private boolean register(String email, String password, String name, Date birthDate, float weight, int height, int maxBpm, int restBpm, ProfileType type) {
		return this.serviceLocator.getService().register(email, password, name, birthDate, weight, height maxBpm, restBpm, type);
	}

}

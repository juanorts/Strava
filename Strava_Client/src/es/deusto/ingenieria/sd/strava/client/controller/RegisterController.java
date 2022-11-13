package es.deusto.ingenieria.sd.strava.client.controller;

import java.rmi.RemoteException;
import java.sql.Date;
import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;

public class RegisterController {
	private ServiceLocator serviceLocator;
	
	public RegisterController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	public boolean register(String email, String password, String name, Date birthDate, float weight, int height, int maxBpm, int restBpm, String ProfileType) throws RemoteException {
		return this.serviceLocator.getService().register(email, password, name, birthDate, weight, height, maxBpm, restBpm, ProfileType);
	}

}

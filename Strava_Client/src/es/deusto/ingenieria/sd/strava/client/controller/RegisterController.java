package es.deusto.ingenieria.sd.strava.client.controller;

import java.rmi.RemoteException;
import java.util.Date;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;

public class RegisterController {
	
	private static RegisterController instance;
	
	private RegisterController() {
	}
	
	public static RegisterController getInstance() {
		if (instance == null) {
			instance = new RegisterController();
		}

		return instance;
	}
	
	public boolean register(String email, String password, String name, Date date, float weight, int height, int maxBpm, int restBpm, String ProfileType) throws RemoteException {
		return ServiceLocator.getInstance().getService().register(email, password, name, date, weight, height, maxBpm, restBpm, ProfileType);
	}

}

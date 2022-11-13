package es.deusto.ingenieria.sd.strava.client.controller;

import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.strava.server.data.*;

public class LoginController {
	private long token;
	private ServiceLocator serviceLocator;
	
	public LoginController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	private boolean login(String email, String password, ProfileType type) {
		try {
			this.token = this.serviceLocator.getService().login(email, password, type);			
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	private void logout() {
		this.serviceLocator.getService().logout(token);
	}
}

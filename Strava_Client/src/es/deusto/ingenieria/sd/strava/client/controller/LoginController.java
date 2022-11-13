package es.deusto.ingenieria.sd.strava.client.controller;

import java.rmi.RemoteException;
import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;

public class LoginController {
	public static long token;
	private ServiceLocator serviceLocator;
	
	public LoginController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	public boolean login(String email, String password, String profileType) {
		try {
			token = this.serviceLocator.getService().login(email, password, profileType);		
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			token = -1;
			return false;
		}
	}
	public void logout() throws RemoteException {
		this.serviceLocator.getService().logout(token);
	}
	
	public long getToken() {
		return token;
	}
}

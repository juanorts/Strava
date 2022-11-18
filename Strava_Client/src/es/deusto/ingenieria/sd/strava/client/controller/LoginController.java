package es.deusto.ingenieria.sd.strava.client.controller;

import java.rmi.RemoteException;
import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;

public class LoginController {
	private long token;
	private static LoginController instance;
	
	private LoginController() {
	}
	
	public static LoginController getInstance() {
		if (instance == null) {
			instance = new LoginController();
		}

		return instance;
	}
	
	public boolean login(String email, String password, String profileType) {
		try {
			token = ServiceLocator.getInstance().getService().login(email, password, profileType);	
			LoginController.getInstance().setToken(token);
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			token = -1;
			return false;
		}
	}
	
	
	
	public void setToken(long token) {
		this.token = token;
	}

	public void logout() throws RemoteException {
		ServiceLocator.getInstance().getService().logout(token);
	}
	
	public long getToken() {
		return token;
	}
}

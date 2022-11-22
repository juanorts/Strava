package es.deusto.ingenieria.sd.google.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;

public class GoogleLoginService extends UnicastRemoteObject implements IGoogleLogin {
	public static GoogleLoginService instance;
	
	private GoogleLoginService() throws RemoteException {
		super();
	}
	
	public static GoogleLoginService getInstance() {
		if (instance == null) {
			try {
				instance = new GoogleLoginService();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}

	@Override
	public Profile login(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}

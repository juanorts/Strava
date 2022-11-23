package es.deusto.ingenieria.sd.google.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;


public class GoogleLoginService extends UnicastRemoteObject implements IGoogleLogin {
	private static final long serialVersionUID = 1L;
	public static GoogleLoginService instance;
	private Map<String, String> GoogleProfileMap = new HashMap<>();
	
	private GoogleLoginService() throws RemoteException {
		this.initializeData();
	}
	
	private void initializeData() {
		GoogleProfileMap.put("mikel@mail.es", "mikel1234");
		GoogleProfileMap.put("alvaro@mail.es", "alvaro1234");
		GoogleProfileMap.put("andoni@mail.es", "andoni1234");
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
	public boolean login(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(" * GoogleLoginService login(): " + email);
		if(GoogleLoginService.getInstance().GoogleProfileMap.get(email).equals(password)) {
			return true;
		}
		return false;
	}
	
	public void addProfile(String email, String password) {
		GoogleLoginService.getInstance().GoogleProfileMap.put(email, password);
	}

	@Override
	public boolean register(String email, String password) throws RemoteException {
		System.out.println(" * GoogleLoginService register(): " + email + " " + password);
		// TODO Auto-generated method stub
		GoogleLoginService.getInstance().addProfile(email, password);
		return true;
	}

	public Map<String, String> getGoogleProfileMap() {
		return GoogleProfileMap;
	}
	
}

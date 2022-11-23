package es.deusto.ingenieria.sd.strava.server.gateway;

import java.rmi.Naming;
import java.util.Map;

import es.deusto.ingenieria.sd.google.remote.IGoogleLogin;

public class GoogleLoginServiceGateway {
	private static GoogleLoginServiceGateway instance;
	private IGoogleLogin googleLoginService;
	
	private GoogleLoginServiceGateway() {
		try {		
			String URL = "//127.0.0.2:1099/Google";
			this.googleLoginService = (IGoogleLogin) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}
	}
	
	public static GoogleLoginServiceGateway getInstance() {
		if(instance == null) {
			instance = new GoogleLoginServiceGateway();
		}
		
		return instance;
	}
	
	public boolean login(String email, String password) {
		System.out.println("   - Login into Google through Gateway");
		
		try {
			return this.googleLoginService.login(email, password);
		} catch (Exception ex) {
			System.out.println("   $ Error logging in: " + ex.getMessage());
			return false;
		}		
	}

	public boolean register(String email, String password) {
		System.out.println("   - Register with Google through Gateway");
		
		try {
			return this.googleLoginService.register(email, password);
		} catch (Exception ex) {
			System.out.println("   $ Error registering: " + ex.getMessage());
			return false;
		}
	}
	public Map<String, String> getGoogleProfileMap() {
System.out.println("   - Obtaining Google profile map through Gateway");
		
		try {
			return this.googleLoginService.getGoogleProfileMap();
		} catch (Exception ex) {
			System.out.println("   $ Error obtaining map: " + ex.getMessage());
			return null;
		}
	}
}

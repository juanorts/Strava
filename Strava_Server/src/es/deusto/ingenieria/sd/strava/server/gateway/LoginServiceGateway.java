package es.deusto.ingenieria.sd.strava.server.gateway;

import java.util.Map;

public abstract class LoginServiceGateway {
	public abstract boolean login(String email, String password);
	
	public abstract boolean register(String email, String password);
	
	public abstract Map<String, String> getProfileMap();
}

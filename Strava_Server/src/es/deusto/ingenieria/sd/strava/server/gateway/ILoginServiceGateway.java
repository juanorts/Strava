package es.deusto.ingenieria.sd.strava.server.gateway;

import java.util.Map;

public interface ILoginServiceGateway {
	public boolean login(String email, String password);
	
	public boolean register(String email, String password);
	
	public Map<String, String> getProfileMap();
}

package es.deusto.ingenieria.sd.strava.server.gateway;

public interface ILoginServiceGateway {
	public boolean login(String email, String password);
	
	public boolean register(String email, String password);
	
	public boolean isRegistered(String email);
}

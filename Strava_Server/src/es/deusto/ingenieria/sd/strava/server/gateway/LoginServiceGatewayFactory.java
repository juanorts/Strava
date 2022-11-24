package es.deusto.ingenieria.sd.strava.server.gateway;

public class LoginServiceGatewayFactory {
	public LoginServiceGateway createGateway(String what) {
		// If Google is requested
		if (what.equals("GOOGLE")) {
			return GoogleLoginServiceGateway.getInstance();
		} else if (what.equals("FACEBOOK")) {
			// TBD: Facebook Gateway
			return null;
		}
		return null;
	}
}

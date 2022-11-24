package es.deusto.ingenieria.sd.strava.server.gateway;

public class LoginServiceGatewayFactory {
	
	private static LoginServiceGatewayFactory instance;

	protected LoginServiceGatewayFactory() {
		super();
	}

	public static LoginServiceGatewayFactory getInstance() {
		if (instance == null) {
			instance = new LoginServiceGatewayFactory();
		}

		return instance;
	}
	
	public ILoginServiceGateway createGateway(String what) {
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

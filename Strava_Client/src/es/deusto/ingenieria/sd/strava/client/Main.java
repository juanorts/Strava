package es.deusto.ingenieria.sd.strava.client;

import es.deusto.ingenieria.sd.strava.client.controller.LoginController;
import es.deusto.ingenieria.sd.strava.client.controller.RegisterController;
import es.deusto.ingenieria.sd.strava.client.controller.StravaController;
import es.deusto.ingenieria.sd.strava.client.gui.LoginWindow;
import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;

public class Main {

	public static void main(String[] args) {
		ServiceLocator serviceLocator = new ServiceLocator();
		
		serviceLocator.setService(args[0], args[1], args[2]);
		
		LoginController loginController = new LoginController(serviceLocator);
		RegisterController registerController = new RegisterController(serviceLocator);
		StravaController stravaController = new StravaController(serviceLocator);
		
		LoginWindow lw = new LoginWindow(loginController, registerController, stravaController);
		lw.setVisible(true);

	}

}

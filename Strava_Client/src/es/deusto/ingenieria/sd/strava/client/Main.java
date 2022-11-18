package es.deusto.ingenieria.sd.strava.client;

import es.deusto.ingenieria.sd.strava.client.gui.LoginWindow;
import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;

public class Main {

	public static void main(String[] args) {
		
		ServiceLocator.getInstance().setService(args[0], args[1], args[2]);
		
		LoginWindow lw = new LoginWindow();
		lw.setVisible(true);

	}

}

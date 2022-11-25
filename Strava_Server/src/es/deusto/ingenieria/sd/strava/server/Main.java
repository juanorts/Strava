package es.deusto.ingenieria.sd.strava.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.strava.server.gateway.FacebookLoginServiceGateway;
import es.deusto.ingenieria.sd.strava.server.remote.IRemoteFacade;
import es.deusto.ingenieria.sd.strava.server.remote.RemoteFacade;

public class Main {

	@SuppressWarnings({ "removal", "deprecation" })
	public static void main(String[] args) {
		// Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		if (args.length < 5) {
			System.err.println(" # Usage: StravaServer [RMI SERVER IP] [RMI PORT] [SERVICE NAME] [SOCKETSERVER IP] [PORT] ");
			System.exit(1);
		}
		// args[0] = RMIRegistry IP
		// args[1] = RMIRegistry Port
		// args[2] = Service Name
		// args[3] = Socket Server IP
		// args[4] = Socket Server Port
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		// Bind remote facade instance to a service name using RMIRegistry
		try {
			IRemoteFacade remoteFacade = new RemoteFacade();
			Naming.rebind(name, remoteFacade);
			FacebookLoginServiceGateway.getInstance().setServerIP(args[3]);
			FacebookLoginServiceGateway.getInstance().setServerPort(Integer.parseInt(args[4]));
			System.out.println(" * Strava Server '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # Strava Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		
		
	}

}

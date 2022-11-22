package es.deusto.ingenieria.sd.google.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.google.remote.GoogleLoginService;
import es.deusto.ingenieria.sd.google.remote.IGoogleLogin;

public class GoogleLoginServer {
	@SuppressWarnings({ "removal", "deprecation" })
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			IGoogleLogin remoteObject = GoogleLoginService.getInstance();			
			Naming.rebind(name, remoteObject);
			System.out.println(" * Google Login Server '" + name + "' started!!");
		} catch (Exception ex) {
			System.out.println(" # Google Login Server: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}

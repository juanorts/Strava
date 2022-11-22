package es.deusto.ingenieria.sd.google.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Profile;

public interface IGoogleLogin extends Remote{
	
	public Profile login(String email, String password) throws RemoteException;

}

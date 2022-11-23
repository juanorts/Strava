package es.deusto.ingenieria.sd.google.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;


public interface IGoogleLogin extends Remote{
	
	public boolean login(String email, String password) throws RemoteException;
	
	public boolean register(String email, String password) throws RemoteException;

	public Map<String, String> getGoogleProfileMap() throws RemoteException;
}

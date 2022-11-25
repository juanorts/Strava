package es.deusto.ingenieria.sd.google.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IGoogleLogin extends Remote{
	
	public boolean login(String email, String password) throws RemoteException;
	
	public boolean register(String email, String password) throws RemoteException;

	boolean isRegistered(String email) throws RemoteException;
}

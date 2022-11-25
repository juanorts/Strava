package es.deusto.ingenieria.sd.google.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

import es.deusto.ingenieria.sd.google.services.GoogleLoginService;

public class GoogleRemoteFacade extends UnicastRemoteObject implements IGoogleLogin{

	private static final long serialVersionUID = 1L;

	public GoogleRemoteFacade() throws RemoteException {
		super();
	}

	@Override
	public boolean login(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(" * GoogleLoginService login(): " + email);
		if (GoogleLoginService.getInstance().login(email, password)) {
			return true;
		} else {
			throw new RemoteException("Login with Google fails, wrong credentials!");
		}
	}

	@Override
	public boolean register(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(" * GoogleLoginService register(): " + email + " " + password);
		if (GoogleLoginService.getInstance().register(email, password)) {
			return true;
		} else {
			throw new RemoteException("Register with Google fails, user is already registered!");
		}
	}

	@Override
	public boolean isRegistered(String email) throws RemoteException {
		return GoogleLoginService.getInstance().isRegistered(email);
	}

}

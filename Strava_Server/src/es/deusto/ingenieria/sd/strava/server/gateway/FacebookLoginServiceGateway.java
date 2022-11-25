package es.deusto.ingenieria.sd.strava.server.gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class FacebookLoginServiceGateway implements ILoginServiceGateway{
	private static FacebookLoginServiceGateway instance;
	private String serverIP;
	private int serverPort;
	private static String DELIMITER = "#";
	
	public static FacebookLoginServiceGateway getInstance() {
		if (instance == null) {
			instance = new FacebookLoginServiceGateway();
		}

		return instance;
	}
	
	protected FacebookLoginServiceGateway() {
		super();
	}

	public void setServerIP(String args) {
		this.serverIP = args;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	@Override
	public boolean login(String email, String password) {
		try (Socket socket = new Socket(serverIP, serverPort);
				//Streams to send and receive information are created from the Socket
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
				out.writeUTF("login" + DELIMITER + email + DELIMITER + password);
				System.out.println(" - Sending data to '" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '" + "login " + email + " '");
				
				if (in.readUTF().equals("true")) {
					return true;
				} else {
					return false;
				}
				
		} catch (UnknownHostException e) {
			System.err.println("# Trans. FacebookLoginServiceGateway: Socket error: " + e.getMessage());	
		} catch (EOFException e) {
			System.err.println("# Trans. FacebookLoginServiceGateway: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# Trans. FacebookLoginServiceGateway: IO error: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean register(String email, String password) {
		// TODO Auto-generated method stub
		try (Socket socket = new Socket(serverIP, serverPort);
				//Streams to send and receive information are created from the Socket
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
				out.writeUTF("register" + DELIMITER + email + DELIMITER + password);
				System.out.println(" - Sending data to '" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '" + "register " + email + " '");
				
				if (in.readUTF().equals("true")) {
					return true;
				} else {
					return false;
				}
				
		} catch (UnknownHostException e) {
			System.err.println("# Trans. FacebookLoginServiceGateway: Socket error: " + e.getMessage());	
		} catch (EOFException e) {
			System.err.println("# Trans. FacebookLoginServiceGateway: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# Trans. FacebookLoginServiceGateway: IO error: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean isRegistered(String email) {
		// TODO Auto-generated method stub
		try (Socket socket = new Socket(serverIP, serverPort);
				//Streams to send and receive information are created from the Socket
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
				out.writeUTF("isRegistered");
				System.out.println(" - Sending data to '" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '" + "isRegistered " + email + " '");
				
				if (in.readUTF().equals("true")) {
					return true;
				} else {
					return false;
				}
				
		} catch (UnknownHostException e) {
			System.err.println("# Trans. FacebookLoginServiceGateway: Socket error: " + e.getMessage());	
		} catch (EOFException e) {
			System.err.println("# Trans. FacebookLoginServiceGateway: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# Trans. FacebookLoginServiceGateway: IO error: " + e.getMessage());
		}
		return false;
	}
	
}

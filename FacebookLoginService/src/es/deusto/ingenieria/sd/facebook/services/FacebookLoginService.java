package es.deusto.ingenieria.sd.facebook.services;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class FacebookLoginService extends Thread {

	private Map<String, String> FacebookProfileMap = new HashMap<>();
	private Socket tcpSocket;
	private DataInputStream in;
	private DataOutputStream out;

	public FacebookLoginService(Socket socket) {
		this.initializeData();
		try {
			this.tcpSocket = socket;
			this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# TranslationService - TCPConnection IO error:" + e.getMessage());
		}
	}

	private void initializeData() {
		FacebookProfileMap.put("pepe@mail.es", "juan1234");
		FacebookProfileMap.put("jose@mail.es", "jose1234");
		FacebookProfileMap.put("juan@mail.es", "juan1234");
	}

	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		if (FacebookProfileMap.get(email).equals(password)) {
			return true;
		}
		return false;
	}

	public void addProfile(String email, String password) {
		FacebookProfileMap.put(email, password);
	}

	public boolean register(String email, String password) {
		// TODO Auto-generated method stub
		addProfile(email, password);
		return true;
	}

	public Map<String, String> getFacebookProfileMap() {
		return FacebookProfileMap;
	}

	public void run() {
		try {
			String data = this.in.readUTF();
			// TBD : Hay que hacer un protocolo para ver si hace register o login
			System.out.println("   - FacebookLoginService - Received data from '"
					+ tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
			// data = this.translate(data);
			this.out.writeUTF(data);
			System.out.println("   - FacebookLoginService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress()
					+ ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
		} catch (EOFException e) {
			System.err.println("   # FacebookLoginService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println("   # FacebookLoginService - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println("   # FacebookLoginService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}
}

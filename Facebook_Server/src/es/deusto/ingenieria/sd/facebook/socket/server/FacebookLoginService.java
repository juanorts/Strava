package es.deusto.ingenieria.sd.facebook.socket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class process the request of each client as a separated Thread.
 */

public class FacebookLoginService extends Thread {
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	private Map<String, String> FacebookProfileMap = new HashMap<>();
	private String message;
	//protected FacebookLoginService instance;

	public FacebookLoginService(Socket tcpSocket) {
		try {
			this.tcpSocket = tcpSocket;
		    this.in = new DataInputStream(this.tcpSocket.getInputStream());
			this.out = new DataOutputStream(this.tcpSocket.getOutputStream());
			this.message = "";
			this.initializeData();
			this.start();
		} catch (IOException e) {
			System.err.println("# FacebookLoginService - TCPConnection IO error:" + e.getMessage());
		}
	}
	
	private void initializeData() {
		FacebookProfileMap.put("mark@mail.es", "mark1234");
		FacebookProfileMap.put("elon@mail.es", "elon1234");
		FacebookProfileMap.put("bill@mail.es", "bill1234");
	}
	
//	public static FacebookLoginService getInstance(Socket socket) {
//		if (instance == null) {
//			try {
//				instance = new FacebookLoginService(socket);
//			} catch(Exception ex) {
//				System.err.println("  # Error initializing service(): " + ex.getMessage());
//			}
//		}
//		
//		return instance;
//	}
	
	public boolean login(String email, String password) {
		if(this.FacebookProfileMap.get(email).equals(password)) {
			return true;
		}
		return false;
	}
	
	public void closeSocket() {
		try {
			tcpSocket.close();
		} catch (IOException e) {
			System.err.println("   # FacebookLoginService - TCPConnection IO error:" + e.getMessage());
		}
	}
	
	public ArrayList<String> receiveData() {
		ArrayList<String> receivedData = new ArrayList<String>();
		try {
			while((this.message = this.in.readUTF()) != null)
			{
				//Read email and password sent from the client
				receivedData.add(this.message);
				System.out.println("   - FacebookLoginService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + this.message + "'");
				this.out.writeUTF(message);
			}
		} catch (EOFException e) {
			System.err.println("   # FacebookLoginService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println("   # FacebookLoginService - TCPConnection IO error:" + e.getMessage());
		}
		return receivedData;
	}
	
	public void run() {
		ArrayList<String> data = new ArrayList<String>();
		data = receiveData();
		for(String s : data) {
			System.out.println("\n" + s + "\n");
		}
		boolean loginP = this.login(data.get(0), data.get(1));
		
		try {
			//this.out.writeUTF(" - FacebookLoginService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + String.valueOf(loginP) + "'");
			System.out.println(" - FacebookLoginService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + String.valueOf(loginP) + "'");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} finally {
			this.closeSocket();
		}
	}
}

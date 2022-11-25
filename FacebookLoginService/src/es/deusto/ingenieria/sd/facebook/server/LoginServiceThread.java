package es.deusto.ingenieria.sd.facebook.server;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

import es.deusto.ingenieria.sd.facebook.services.FacebookLoginService;

import java.io.DataInputStream;

public class LoginServiceThread extends Thread{
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;

	private static String DELIMITER = "#";
	
	public LoginServiceThread(Socket socket) {
		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# FacebookLoginService - TCPConnection IO error:" + e.getMessage());
		}
	}
	
	public void run() {
		try {
			String data = this.in.readUTF();			
			System.out.println("   - TranslationService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");					
			/*data = this.translate(data);
			this.out.writeUTF(data);*/		
			if (data != null && !data.trim().isEmpty()) {
				try {
					StringTokenizer tokenizer = new StringTokenizer(data, DELIMITER);		
					String method = tokenizer.nextToken();
					String arg1 = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null;
					String arg2 = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null;
					switch(method) {
					case "login" :
						boolean loginSuccess = FacebookLoginService.getInstance().login(arg1, arg2);
						if (loginSuccess) {
							data = "true";
						} else {
							data = "false";
						}
					case "register" :
						boolean registerSuccess = FacebookLoginService.getInstance().register(arg1, arg2);
						if (registerSuccess) {
							data = "true";
						} else {
							data = "false";
						}
					case "isRegistered" :
						boolean isRegistered = FacebookLoginService.getInstance().isRegistered(arg1);
						if (isRegistered) {
							data = "true";
						} else {
							data = "false";
						}
					}
				} catch (Exception e) {
					System.err.println("   # FacebookLoginService - FacebookLogin API error:" + e.getMessage());
					data = null;
				}
			}
			this.out.writeUTF(data);
			
			System.out.println("   - FacebookLoginService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
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

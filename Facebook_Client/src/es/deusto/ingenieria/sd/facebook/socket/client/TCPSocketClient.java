package es.deusto.ingenieria.sd.facebook.socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPSocketClient {

	Socket tcpSocket;
	
	public static void main(String args[]) {
		
		if (args.length < 2) {
			System.err.println(" # Usage: TCPSocketClient [SERVER IP] [PORT]");
			System.exit(1);
		}
		
		//args[0] = Server IP
		String serverIP = args[0];
		//args[1] = Server socket port
		int serverPort = Integer.parseInt(args[1]);
		
		TCPSocketClient client = new TCPSocketClient(serverIP, serverPort);
		
		//	Read mail and password from client and send data to the server
		try (
		Scanner sc = new Scanner(System.in)) {
			System.out.println("Mail: ");
			String email = sc.nextLine();
			System.out.println("Password: ");
			String password = sc.nextLine();
			//	Send email and password
			client.sendData(email);
			client.sendData(password);
		}
	    
	}
	
	public TCPSocketClient(String serverIP, int serverPort) {
		try {
			this.tcpSocket = new Socket(serverIP, serverPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendData(String message) {
		
		try {
			 //Streams to send and receive information are created from the Socket
		     DataInputStream in = new DataInputStream(this.tcpSocket.getInputStream());
			 DataOutputStream out = new DataOutputStream(this.tcpSocket.getOutputStream());
			
			//Send email to the server
			out.writeUTF(message);
			System.out.println(" - TCPSocketClient: Sent data to '" + this.tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + message + "'");
			
			//Read response (a String) from the server
			String data = in.readUTF();			
			System.out.println(" - TCPSocketClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
		} catch (UnknownHostException e) {
			System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
		}
	}
	
}
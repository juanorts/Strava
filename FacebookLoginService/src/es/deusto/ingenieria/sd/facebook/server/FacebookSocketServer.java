package es.deusto.ingenieria.sd.facebook.server;

import java.io.IOException;
import java.net.ServerSocket;


public class FacebookSocketServer {
	private static int numClients = 0;

	public static void main(String args[]) {
		if (args.length < 1) {
			System.err.println(" # Usage: FacebookSocketServer [PORT]");
			System.exit(1);
		}

		// args[1] = Server socket port
		int serverPort = Integer.parseInt(args[0]);

		try (ServerSocket tcpServerSocket = new ServerSocket(serverPort);) {
			System.out.println(" - FacebookSocketServer: Waiting for connections '"
					+ tcpServerSocket.getInetAddress().getHostAddress() + ":" + tcpServerSocket.getLocalPort()
					+ "' ...");

			while (true) {
				new LoginServiceThread(tcpServerSocket.accept());
				System.out.println(
						" - FacebookSocketServer: New client connection accepted. Client number: " + ++numClients);
			}
		} catch (IOException e) {
			System.err.println("# FacebookSocketServer: IO error:" + e.getMessage());
		}
	}
}

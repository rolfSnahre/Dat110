package no.hvl.dat110.messaging;

import java.io.IOException;

import java.net.Socket;

public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	// connect to messaging server
	public Connection connect() {

		Socket clientSocket;
		Connection connection = null;

		// TODO
		// create TCP socket for client and connection

		try {
			clientSocket = new Socket(server, port);			
			connection = new Connection(clientSocket);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		if (true) {
			throw new RuntimeException("not yet implemented");
		}

		return connection;
	}
}

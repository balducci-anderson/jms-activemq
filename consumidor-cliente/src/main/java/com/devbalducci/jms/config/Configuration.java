package com.devbalducci.jms.config;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Session;
import javax.naming.InitialContext;

public class Configuration {

	private InitialContext context;
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	
	public void configura() throws Exception {
		
		context = new InitialContext();
		
		factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		
		connection = factory.createConnection();
		connection.start();
		
		session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);		
	}
	
	public Destination lookupFila(String fila) throws Exception {
		return (Destination)context.lookup(fila);
	}

	public void close() throws Exception {
		session.close();
		connection.close();
		context.close();
	}

	public Session getSession() {
		return session;
	}
}

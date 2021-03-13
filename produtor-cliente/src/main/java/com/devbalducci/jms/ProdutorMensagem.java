package com.devbalducci.jms;

import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import com.devbalducci.jms.config.Configuration;
import com.devbalducci.jms.dominio.Cliente;

public class ProdutorMensagem {

	public void executa() throws Exception {
		
		Configuration configuration = new Configuration();
		
		configuration.configura();
		
		Session session = configuration.getSession();
		
		sendCliente(session, configuration, "José", "111.111.111-00", 1200);
		sendCliente(session, configuration, "Antonio", "222.222.333-11", 5700);
		sendCliente(session, configuration, "João", "333.333.333-22", 10300);
		
		configuration.close();
	}
	
	private void sendCliente(Session session, Configuration configuration, String nome, 
			String cpf, double salario) throws Exception {
		
		Cliente cliente = new Cliente(nome, cpf, salario);
		
		Message message = session.createObjectMessage(cliente);
		
		MessageProducer producer = session.createProducer(configuration.lookupFila("cliente-create"));
		
		// Inserindo propriedade salário para utilizar selector no produtor
		message.setDoubleProperty("salario", cliente.getSalario());
		
		producer.send(message);
		
		message.acknowledge();
	}
}

package com.devbalducci.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.devbalducci.jms.config.Configuration;
import com.devbalducci.jms.dominio.Cliente;

public class ConsumidorMensagem {

	public void executa() throws Exception {
		
		Configuration configuration = new Configuration();
		
		configuration.configura();
		
		Session session = configuration.getSession();
		
		receiveCliente(session, configuration);
		
		configuration.close();
	}
	
	private void receiveCliente(Session session, Configuration configuration) throws Exception {

		// Imprime clientes com salário maior que 5000
		MessageConsumer consumer = session.createConsumer(configuration.lookupFila("cliente-create"), "salario > 5000");

		while(true) {
			consumer.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message message) {
	
					try {
						Cliente cliente = (Cliente)((ObjectMessage)message).getObject();
						
						// Imprime clientes com salário maior que 3000
						
						System.out.println("Nome: " + cliente.getNome());
						System.out.println("CPF: " + cliente.getCpf());
						System.out.println("Salário: " + cliente.getSalario());
						System.out.println("----------");
						
						message.acknowledge();
						
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
}

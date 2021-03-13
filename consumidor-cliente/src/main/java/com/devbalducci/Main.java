package com.devbalducci;

import com.devbalducci.jms.ConsumidorMensagem;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","java.lang,com.devbalducci.jms.dominio");
		
		ConsumidorMensagem consumidor = new ConsumidorMensagem();
		consumidor.executa();
	}

}

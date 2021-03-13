package com.devbalducci;

import com.devbalducci.jms.ProdutorMensagem;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ProdutorMensagem produtor = new ProdutorMensagem();
		produtor.executa();
	}

}

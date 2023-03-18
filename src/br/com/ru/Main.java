package br.com.ru;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.*;


public class Main {

	public static void main(String[] args) throws ElementoJaExisteException, ElementoNaoExisteException {
		
		ControladorCliente Ccliente = new ControladorCliente();

		
		Ccliente.criarCliente("Diogo", "Fontes", "123456","lindo", "gostosao");
		Ccliente.criarCliente("Igor", "Rosa", "40028922", "feio", "tenebroso");
		
		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("123456"));
		
		Ccliente.atualizarCliente("123456", "Maravilhoso", "Fontes", "123456", "lindo", "gostosao");
		
		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("123456"));
		
		Ccliente.atualizarCliente("123456", "Maravilhoso", "Fontes", "654321", "lindo", "gostosao");
		
		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("654321"));
		
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
						+ "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
						+ "|||||||||||||||||||||");
		
		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("40028922"));
		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("654321"));
		
		Ccliente.excluirCliente("40028922");
		
		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("40028922"));
		
		
	}

}

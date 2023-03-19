package br.com.ru;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.*;


public class Main {

	public static void main(String[] args) throws ElementoJaExisteException, ElementoNaoExisteException {
		
		ControladorCliente Ccliente = new ControladorCliente();
		ControladorPrato Cprato = new ControladorPrato();
		ControladorFuncionario Cfunc = new ControladorFuncionario();
		
		Cfunc.adicionarFuncionario("Diogo", "Filipe", "45142", "a", "b", "d");
		Cfunc.adicionarFuncionario("Luiz", "Fontes", "77889", "e", "f", "h");
		
		System.out.println("Existe: " + Cfunc.listar());
		
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
						+ "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
						+ "|||||||||||||||||||||");
		
		Cfunc.atualizarFuncionario("77889", "Shaulin", "MatadorDePorco", "77889", "a", "b", "h");
		//verificar cpf
		
		System.out.println("Existe: " + Cfunc.listar());
		
		Cfunc.excluirFuncionario("45142");
		
		System.out.println("Existe: " + Cfunc.listar());
		
//		Cprato.adicionarPrato("IgorMilanesa", false, true, false, true, true);
//		Cprato.adicionarPrato("FontesAtrua", false, true, false, true, true);
//
//		System.out.println("Existe: " + Cprato.mostrarCardapio());
//		
//		//a cagada qeu luiz fez presta?
//		
//		Cprato.atualizarPrato("IgorMilanesa", "IgorDefumado", false, false, false, false, true);
//		
//		System.out.println("Existe: " + Cprato.mostrarCardapio());
//		
//		Cprato.removerPrato("FontesAtrua");
//		
//		System.out.println("Existe: " + Cprato.mostrarCardapio());
//		Ccliente.criarCliente("Diogo", "Fontes", "123456","lindo", "gostosao");
//		Ccliente.criarCliente("Igor", "Rosa", "40028922", "feio", "tenebroso");
//		
//		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("123456"));
//		
//		Ccliente.atualizarCliente("123456", "Maravilhoso", "Fontes", "123456", "lindo", "gostosao");
//		
//		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("123456"));
//		
//		Ccliente.atualizarCliente("123456", "Maravilhoso", "Fontes", "654321", "lindo", "gostosao");
//		
//		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("654321"));
//		
//		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
//					+ "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
//						+ "|||||||||||||||||||||");
//		
//		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("40028922"));
//		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("654321"));
//		
//		Ccliente.excluirCliente("40028922");
//		
//		System.out.println("Existe: " + Ccliente.listarClienteEspecifico("40028922"));
		
		
		
	}

}

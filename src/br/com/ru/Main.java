package br.com.ru;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.*;


public class Main {

	public static void main(String[] args) throws ElementoJaExisteException, ElementoNaoExisteException {
	
		Sistema meuSistema = new Sistema();
		Sistema meuSistema2 = new Sistema();
		
		
		
		meuSistema.adicionarCliente("Luiz", "Filipe", "123", "a", "22");
		meuSistema2.procurarClienteExpecifico("123");
		meuSistema.adicionarCliente("Diogo", "Fontes", "321", "b", "22");
		
		meuSistema.procurarClienteExpecifico("321");
		meuSistema.atualizarCliente("321", "Fontes", "França", "321", "v", "33");
		meuSistema.procurarClienteExpecifico("321");
		
		meuSistema.removerCliente("123");
		
		meuSistema.adicionarFuncionario("Raphael", "Barbosa", "456", "c", "22", "d");
		System.out.println(meuSistema.listarFuncionarios());
		meuSistema.atualizarFuncionario("456", "Beatriz", "Santos", "456", "c", "22", "d");
		System.out.println(meuSistema.listarFuncionarios());
		
		
		
		meuSistema.adicionarPrato("Beringela", true, false, false, false, false, true);
		meuSistema.adicionarPrato("Bolo", false, true, true, false, true, true);
		System.out.println(meuSistema.cardapio());
		meuSistema.removerPrato("Beringela");
		System.out.println(meuSistema.cardapio());
		meuSistema.atualizarPrato("Bolo", "Suco de Bolo", false, true, true, true, true, true);
		System.out.println(meuSistema.cardapio());
		
		
//		ControladorCliente Ccliente = new ControladorCliente();
//		ControladorUsuario Cusuario = new ControladorUsuario();
//		ControladorUsuario CusuarioF = new ControladorFuncionario();
//		//ControladorPrato Cprato = new ControladorPrato();
//		ControladorFuncionario Cfunc = new ControladorFuncionario();
//		
//
//		
//		
//		//Cfunc.adicionarFuncionario("Diogo", "Filipe", "123456", "a", "b", "d");
//		
//		//Criação de Clientes
//		Ccliente.criarCliente("Diogo", "Fontes", "123456", "a", "2222222");
//		Ccliente.criarCliente("Diogo", "Fontes", "40028922", "porra", "suicidio");
//		
////		//Listar Clientes. obs(O metodo listar já utilza o metodo recover)
//		Ccliente.listarClienteEspecifico("40028922");
//		Ccliente.listarClienteEspecifico("123456");
////		
////		
////		
////		//Remover Cliente
//		Ccliente.excluirCliente("123456");
////		
//		//Ccliente.listarClienteEspecifico("123456");
//		
//		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
//						 + "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
//						 + "|||||||||||||||||||||");
////		
////		//Criação de Funcionario
//		Cfunc.adicionarFuncionario("Diogo", "Filipe", "123456", "b", "b", "d");
//		Cfunc.adicionarFuncionario("Diogo", "Filipe", "312", "c", "b", "d");
////		
////		//Listar Funcionarios
////		
//		System.out.println(Cfunc.listarFuncionarios());
////		
////			
////		//Remover funcionario
//		Cfunc.excluirFuncionario("123456");
//		Ccliente.criarCliente("Diogo", "Fontes", "123456", "a", "2222222");
//		System.out.println(Cfunc.listarFuncionarios());
//		Ccliente.listarClienteEspecifico("123456");
		
	
		
		
		//Ccliente.listarClienteEspecifico("312");
		//System.out.println("existe: " + Ccliente.listarClienteEspecifico("123456"));
		//System.out.println("existe: " + Cfunc.listar());
//		Cfunc.adicionarFuncionario("Luiz", "Fontes", "77889", "e", "f", "h");
//		
//		System.out.println("Existe: " + Cfunc.listar());
//		
//		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
//						+ "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
//						+ "|||||||||||||||||||||");
//		
//		Cfunc.atualizarFuncionario("77889", "Shaulin", "MatadorDePorco", "77889", "a", "b", "h");
//		//verificar cpf
//		
//		System.out.println("Existe: " + Cfunc.listar());
//		
//		Cfunc.excluirFuncionario("45142");
//		
//		System.out.println("Existe: " + Cfunc.listar());
		
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
//		Ccliente.criarCliente("Igor", "Rosa", "12356", "feio", "tenebroso");
		
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

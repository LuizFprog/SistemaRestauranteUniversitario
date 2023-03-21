package br.com.ru;

import java.util.Scanner;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import br.com.ru.negocio.*;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;


public class Main {

	public static void main(String[] args) throws ElementoJaExisteException, ElementoNaoExisteException, SaldoInsuficienteException {
	
		Sistema meuSistema = new Sistema();
		Scanner scan = new Scanner(System.in);
		Ficha fichaPadrao = new Ficha(null,null);
		
		
		int sent;
		boolean cadastradoF = false;
		boolean cadastradoC = false;
		
		String primeiroNome, ultimoNome, cpf, login, senha, id;
		
		do {
			
			System.out.printf("Aperte 1 para entrar como Funcionário || Aperte 2 para entrar como Cliente || Aperte 3 para registrar%n");
			sent = scan.nextInt();
			
			
			switch(sent) {
			
			case 1:
				
				if(cadastradoF) {
					
					
					
				}else {
					
				}
				break;
				
			case 2:
				
				if(cadastradoC) {
					
					boolean saida = false;
					
					System.out.println("Digite seu cpf");
					cpf = scan.next();	
					
					do {
						
										
						
						System.out.println("Digite 1 para comprar Ficha || Digite 2 para adiconar saldo|| Digite 3 para acessar o cardapio || Digite 4 acessar seu perfil "
											+ "|| Digite 5 para sair");
						
						sent = scan.nextInt();
						
						switch(sent) {
						
						case 1:
							System.out.println("Digite o numero de fichas que deseja comprar");
							int numeroFichas = scan.nextInt();
							
							
							 if(meuSistema.recuperarClienteExpecifico(cpf) != null) {
								 meuSistema.adicionarFicha(fichaPadrao.getPreco(), numeroFichas*fichaPadrao.getPreco() ,meuSistema.recuperarClienteExpecifico(cpf));
							 }
							
							 System.out.println(meuSistema.listarFichaPorCliente(meuSistema.recuperarClienteExpecifico(cpf)));
							 break;
						case 2:
							System.out.println("Digite o valor do PIX (obs: sem casa decimal!)");
							int valor  = scan.nextInt();
					
							
							meuSistema.depositar(valor, cpf);
							System.out.println(meuSistema.procurarClienteExpecifico(cpf));
							break;
						case 3:
							System.out.println("Cardapio:");
							System.out.println(meuSistema.cardapio());
						case 4:
							System.out.println(meuSistema.recuperarClienteExpecifico(cpf));
							break;
						case 5:
							saida = true;
						}
						
					}while(!saida);
					
				}else {
					
				}
				break;
				
			case 3:
				System.out.println("Digite 1 para Funcionário || Digite 2 para Cliente");
				sent = scan.nextInt();
				switch(sent) {
				
				case 1:
					
					System.out.println("Digite da seguinte forma: primeiroNome ultimoNome cpf login senha id");
					primeiroNome = scan.next();
					ultimoNome = scan.next();
					cpf = scan.next();
					login = scan.next();
					senha = scan.next();
					id = scan.next();
					
					meuSistema.adicionarFuncionario(primeiroNome, ultimoNome, cpf, login, senha, id);
					cadastradoF = true;
	
					System.out.println(meuSistema.listarTodosFuncionarios());
					break;
					
				case 2:
					
					System.out.println("Digite da seguinte forma: primeiroNome ultimoNome cpf login senha");
					primeiroNome = scan.next();
					ultimoNome = scan.next();
					cpf = scan.next();
					login = scan.next();
					senha = scan.next();
				
					meuSistema.adicionarCliente(primeiroNome, ultimoNome, cpf, login, senha);
					cadastradoC = true;
					System.out.println(meuSistema.listarTodosClientes());
					break;
				}
				
			}
			
			
		}while(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Sistema meuSistema2 = new Sistema();
//		
//		
//		
//		meuSistema.adicionarCliente("Luiz", "Filipe", "123", "a", "22");
//		//meuSistema2.procurarClienteExpecifico("123");
//		meuSistema.adicionarCliente("Diogo", "Fontes", "321", "b", "22");
//		
//		meuSistema.adicionarFuncionario("Raphael", "csgo2", "222", "ffff", "22","bbc");
//		meuSistema.adicionarFuncionario("Carlos", "Olaquetal", "333", "bbb", "22","bbc");
//		
//		System.out.println(meuSistema.listarTodosUsuarios());
//		System.out.println();
//		System.out.println(meuSistema.listarTodosClientes());
//		System.out.println();
//		System.out.println(meuSistema.listarTodosFuncionarios());
		
//		meuSistema.depositar(100, "123");
//		System.out.println(meuSistema.procurarClienteExpecifico("123"));
//		meuSistema.debitar(10, "321");
//		meuSistema.adicionarFicha(3.0 ,10.0, meuSistema.recuperarClienteExpecifico("123"));
//		System.out.println(meuSistema.procurarClienteExpecifico("123"));
//		System.out.println(meuSistema.listarFichaPorCliente(meuSistema.recuperarClienteExpecifico("123")));
//		System.out.println(meuSistema.listarFicha());
//		meuSistema.gastarFicha(meuSistema.recuperarFichaDoCliente(meuSistema.recuperarClienteExpecifico("123")));
//		System.out.println(meuSistema.listarFichaPorCliente(meuSistema.recuperarClienteExpecifico("123")));
		
//		meuSistema.procurarClienteExpecifico("321");
//		meuSistema.atualizarCliente("321", "Fontes", "França", "321", "v", "33");
//		meuSistema.procurarClienteExpecifico("321");
//		
//		meuSistema.removerCliente("123");
//		
//		meuSistema.adicionarFuncionario("Raphael", "Barbosa", "456", "c", "22", "d");
//		System.out.println(meuSistema.listarFuncionarios());
//		meuSistema.atualizarFuncionario("456", "Beatriz", "Santos", "456", "c", "22", "d");
//		System.out.println(meuSistema.listarFuncionarios());
//		
//		
//		
//		meuSistema.adicionarPrato("Beringela", true, false, false, false, false, true);
//		meuSistema.adicionarPrato("Bolo", false, true, true, false, true, true);
//		System.out.println(meuSistema.cardapio());
//		meuSistema.removerPrato("Beringela");
//		System.out.println(meuSistema.cardapio());
//		meuSistema.atualizarPrato("Bolo", "Suco de Bolo", false, true, true, true, true, true);
//		System.out.println(meuSistema.cardapio());
		
		
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

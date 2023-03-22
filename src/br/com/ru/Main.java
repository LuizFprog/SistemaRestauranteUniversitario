package br.com.ru;

import java.util.Scanner;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import br.com.ru.negocio.*;
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
		String nomePrato;
		String nomeAtual, novoNome;
		int numeroFichas;
		int valor;
		
		try
		{
			do {
				
				System.out.printf("Aperte 1 para entrar como Funcionário || Aperte 2 para entrar como Cliente || Aperte 3 para registrar%n");
				do
				{
					sent = scan.nextInt();
					if(sent != 1 && sent != 2 && sent != 3)
					{
						System.out.println("Operação invalida! Digite novamente");
					}
				}while(sent != 1 && sent != 2 && sent != 3);
							
				switch(sent) {
				
				case 1:
					
					if(cadastradoF) {
						boolean saida = false;
						
						System.out.println("Digite seu cpf");
						do
						{
							cpf = scan.next();
						}while(cpf == null);
						
						do { 
							
							System.out.println("Digite 1 para editar o Cardápio || Digite 2 para editar os Pratos || Digite 3 para acessar as informações dos clientes || Digite 4 para sair ");
				
							sent = scan.nextInt();
							
							switch(sent) {
													
							case 1:
								
								//ToDo
								System.out.println(meuSistema.cardapio());
								System.out.println("Digite 1 para adicionar um prato no cardapio || Digite 2 para remover um prato do cardapio");
								do
								{
									sent = scan.nextInt();
									if(sent != 1 && sent != 2 && sent != 3)
									{
										System.out.println("Operação invalida! Digite novamente");
									}
								}while(sent != 1 && sent != 2 && sent != 3);
								switch(sent)
								{
								case 1:
									System.out.println(meuSistema.verTodosPratos());
									System.out.println("Digite o nome do prato para adicão no cardapio:");
									nomePrato = scan.next();
									if(meuSistema.recuperarPrato(nomePrato).isVisivel() == false)
									{
										meuSistema.colocarNoCardapio(meuSistema.recuperarPrato(nomePrato));
									}
									else
									{
										System.out.println("Prato mencionado já está no cardapio");
									}
									
									break;
								case 2:
									System.out.println(meuSistema.cardapio());
									System.out.println("Digite o nome do prato para remoção do cardapio");
									nomePrato = scan.next();
									if(meuSistema.recuperarPrato(nomePrato).isVisivel() == true)
									{
										meuSistema.removerDoCardapio(meuSistema.recuperarPrato(nomePrato));
									}
									else
									{
										System.out.println("Prato mencionado já está fora do cardapio");
									}
									break;
								}
								break;
							case 2:
								
								System.out.println("Digite 1 para criar um prato || Digite 2 para editar um prato || Digite 3 para remover um prato || Digite 4 para listar os pratos ");
								do
								{
									sent = scan.nextInt();
									if(sent != 1 && sent != 2 && sent != 3 && sent != 4 && sent != 5)
									{
										System.out.println("Operação invalida! Digite novamente");
									}
								}while(sent != 1 && sent != 2 && sent != 3 && sent != 4 && sent != 5);
								
								switch(sent) {
								
								case 1:
									
									System.out.println("Digite o nome do prato: ");
									String nome = scan.next();
									boolean vegano = false;
									boolean gluten = false;
									boolean lactose = false;
									boolean suco = false;
									boolean sobremesa = false;
									boolean visivel = false;
									
									System.out.println("O prato é vegano? (1 = sim | 2 = não) ");
									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);

									switch(sent) {
									
									case 1:
										
										vegano = true;
										break;
										
									case 2: 
										
										vegano = false;
										break;
										
									}
									
									System.out.println("O prato tem glúten? (1 = sim | 2 = não) ");

									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									
									switch(sent) {
									
									case 1:
										
										gluten = true;
										break;
										
									case 2:
										
										gluten = false;
										break;
										
									}
									
									System.out.println("O prato tem lactose? (1 = sim | 2 = não) ");

									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									
									switch(sent) {
									
									case 1:
										
										lactose = true;
										break;
										
									case 2: 
										
										lactose = false;
										break;
										
									}
									
									System.out.println("O prato é um suco? (1 = sim | 2 = não) ");

									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									
									switch(sent) {
									
									case 1:
										
										suco = true;
										break;
										
									case 2: 
										
										suco = false;
										break;
										
									}
									
									System.out.println("O prato é uma sobremesa? (1 = sim | 2 = não) ");

									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									switch(sent) {
									
									case 1:
										
										sobremesa = true;
										break;
										
									case 2:
										
										sobremesa = false;
										break;
										
									}
									
									System.out.println("O prato deve aparecer no cardápio? (1 = sim | 2 = não) ");

									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									
									switch(sent) {
									
									case 1:
										
										visivel = true;
										break;
										
									case 2:
										
										visivel = false;
										break;
										
									}
									meuSistema.adicionarPrato(nome, vegano, gluten, lactose, suco, sobremesa, visivel);
									break;
									
								case 2: 
									
									vegano = false;
									gluten = false;
									lactose = false;
									suco = false;
									sobremesa = false;
									visivel = false;
									
									System.out.println("Digite o nome do prato atual: ");
									do
									{
										nomeAtual = scan.next();
									}while(nomeAtual == null);
									
									System.out.println("Digite o novo nome do prato: ");
									do
									{
										novoNome = scan.next();
									}while(novoNome == null);
									
									System.out.println("O prato é vegano? (1 = sim | 2 = não) ");
									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									
									switch(sent) {
									
									case 1:
										
										vegano = true;
										break;
										
									case 2: 
										
										vegano = false;
										break;
										
									}
									
									System.out.println("O prato tem glúten? (1 = sim | 2 = não) ");
									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									
									switch(sent) {
									
									case 1:
										
										gluten = true;
										break;
										
									case 2: 
										
										gluten = false;
										break;
										
									}
									
									System.out.println("O prato tem lactose? (1 = sim | 2 = não) ");
									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									
									switch(sent) {
									
									case 1:
										
										lactose = true;
										break;
										
									case 2: 
										
										lactose = false;
										break;
										
									}
									
									System.out.println("O prato é um suco? (1 = sim | 2 = não) ");
									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									
									switch(sent) {
									
									case 1:
										
										suco = true;
										break;
										
									case 2: 
										
										suco = false;
										break;
										
									}
									
									System.out.println("O prato é uma sobremesa? (1 = sim | 2 = não) ");
									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									
									switch(sent) {
									
									case 1:
										
										sobremesa = true;
										break;
										
									case 2: 
										
										sobremesa = false;
										break;
										
									}
									
									System.out.println("O prato deve aparecer no cardápio? (1 = sim | 2 = não) ");
									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2);
									
									switch(sent) {
									
									case 1:
										
										visivel = true;
										break;
										
									case 2: 
										
										visivel = false;
										break;
										
									}
									
									meuSistema.atualizarPrato(nomeAtual, novoNome, vegano, gluten, lactose, suco, sobremesa, visivel);
									break;
									
								case 3: 
									
									System.out.println("Digite o nome do prato para ser removido: ");
									nome = scan.next();
									
									meuSistema.removerPrato(nome);
									break;
									
								case 4:
									
									System.out.println(meuSistema.cardapio());
									break;
																
								}
								break;
								
							case 3:
								
								System.out.println("Clientes:");
								System.out.println(meuSistema.listarTodosClientes());
								break;
								
							case 4:
								
								saida = true;
								break;
								
							}
					
						} while(!saida);				
					
					}else {
						System.out.println("Funcionario não cadastrado!");
					}
					break;			
					
				case 2:
					
					if(cadastradoC) {
						
						boolean saida = false;
						
						System.out.println("Digite seu cpf");
						do
						{
							cpf = scan.next();
						}while(cpf == null);	
						
						do {				
							
							System.out.println("Digite 1 para comprar Ficha || Digite 2 para adiconar saldo|| Digite 3 para acessar o cardapio || Digite 4 acessar seu perfil "
												+ "|| Digite 5 para sair");
							do
							{
								sent = scan.nextInt();
								if(sent != 1 && sent != 2 && sent != 3 && sent != 4 && sent != 5)
								{
									System.out.println("Operação invalida! Digite novamente");
								}
							}while(sent != 1 && sent != 2 && sent != 3 && sent != 4 && sent != 5);
							
							switch(sent) {
							
							case 1:
								
								System.out.println("Digite o numero de fichas que deseja comprar");
								do
								{
									numeroFichas = scan.nextInt();
								}while(numeroFichas <= 0);				
								
								 if(meuSistema.recuperarClienteExpecifico(cpf) != null) {
									 meuSistema.adicionarFicha(fichaPadrao.getPreco(), numeroFichas*fichaPadrao.getPreco() ,meuSistema.recuperarClienteExpecifico(cpf));
								 }
								
								 System.out.println(meuSistema.listarFichaPorCliente(meuSistema.recuperarClienteExpecifico(cpf)));
								 break;
								 
							case 2:
								
								System.out.println("Digite o valor do PIX (obs: sem casa decimal!)");
								do
								{
									valor = scan.nextInt();
								}while(valor <= 0);					
								
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
						System.out.println("Cliente não cadastrado!");
					}
					break;
					
				case 3:
					
					System.out.println("Digite 1 para Funcionário || Digite 2 para Cliente");
					do
					{
						sent = scan.nextInt();
						if(sent != 1 && sent != 2)
						{
							System.out.println("Operação invalida! Digite novamente");
						}
					}while(sent != 1 && sent != 2);
					switch(sent) {
					
					case 1:
						
						System.out.println("Digite da seguinte forma: primeiroNome ultimoNome cpf login senha id");
						do
						{
							primeiroNome = scan.next();
						}while(primeiroNome == null);	
						do
						{
							ultimoNome = scan.next();
						}while(ultimoNome == null);	
						do
						{
							cpf = scan.next();
						}while(cpf == null);	
						do
						{
							login = scan.next();
						}while(login == null);	
						do
						{
							senha = scan.next();
						}while(senha == null);	
						do
						{
							id = scan.next();
						}while(id == null);	
						
						meuSistema.adicionarFuncionario(primeiroNome, ultimoNome, cpf, login, senha, id);
						cadastradoF = true;
		
						System.out.println(meuSistema.listarTodosFuncionarios());
						break;
						
					case 2:
						
						System.out.println("Digite da seguinte forma: primeiroNome ultimoNome cpf login senha");
						do
						{
							primeiroNome = scan.next();
						}while(primeiroNome == null);	
						do
						{
							ultimoNome = scan.next();
						}while(ultimoNome == null);	
						do
						{
							cpf = scan.next();
						}while(cpf == null);	
						do
						{
							login = scan.next();
						}while(login == null);	
						do
						{
							senha = scan.next();
						}while(senha == null);	
					
						meuSistema.adicionarCliente(primeiroNome, ultimoNome, cpf, login, senha);
						cadastradoC = true;
						System.out.println(meuSistema.listarTodosClientes());
						break;
					}
					
				}
				
			}while(true);
		}
		catch(ElementoJaExisteException e)
		{
			System.err.println(e + " O objeto já existe!");
		}
		catch(ElementoNaoExisteException e)
		{
			System.err.println(e + " O objeto mencionado não existe!");
		}
		catch(SaldoInsuficienteException e)
		{
			System.err.println(e + " Saldo do cliente insuficiente para realizar a compra!");
		}
		
	}

}

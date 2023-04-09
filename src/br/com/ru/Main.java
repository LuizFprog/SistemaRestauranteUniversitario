package br.com.ru;

import java.util.Scanner;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import br.com.ru.negocio.*;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.ItemConsumivel.TipoCardapio;


public class Main {

	public static void main(String[] args) throws ElementoJaExisteException, ElementoNaoExisteException, SaldoInsuficienteException {
	
		Sistema meuSistema = new Sistema();
		Scanner scan = new Scanner(System.in);		
		
		int sent;
		boolean cadastradoF = false;
		boolean cadastradoC = false;
		
		String primeiroNome, ultimoNome, cpfCliente, cpfFuncionario, cpf, login, senha, id;
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
							
						
						meuSistema.recuperarFuncionarioEspecifico(cpf);
						
						do { 
							
							System.out.println("Digite 1 para editar o Cardápio || Digite 2 para editar os Pratos || Digite 3 para acessar as informações dos usuários || Digite 4 para sair ");
				
							do
							{
								sent = scan.nextInt();
								if(sent != 1 && sent != 2 && sent != 3 && sent != 4)
								{
									System.out.println("Operação invalida! Digite novamente");
								}
							}while(sent != 1 && sent != 2 && sent != 3 && sent != 4);
							
							switch(sent) {
													
							case 1:
								System.out.println("TRIVIAL:");
								System.out.println(meuSistema.cardapioTrivial());
								System.out.println("VEGANO:");
								System.out.println(meuSistema.cardapioVegano());
								System.out.println("SUCO:");
								System.out.println(meuSistema.cardapioSuco());
								System.out.println("SOBREMESA:");
								System.out.println(meuSistema.cardapioSobremesa());
								System.out.println("Digite 1 para adicionar um prato no cardapio || Digite 2 para remover um prato do cardapio");
								do
								{
									sent = scan.nextInt();
									if(sent != 1 && sent != 2)
									{
										System.out.println("Operação invalida! Digite novamente");
									}
								}while(sent != 1 && sent != 2);
								switch(sent)
								{
								case 1:
									System.out.println(meuSistema.verTodosItemConsumiveis());
									System.out.println("Digite o nome do prato para adicão no cardapio:");
									scan.nextLine();
									nomePrato = scan.nextLine();
									if(meuSistema.recuperarItemConsumivel(nomePrato).isVisivel() == false)
									{
										meuSistema.colocarNoCardapio(meuSistema.recuperarItemConsumivel(nomePrato));
									}
									else
									{
										System.out.println("Prato mencionado já está no cardapio");
									}
									
									break;
								case 2:
									System.out.println(meuSistema.cardapio());
									System.out.println("Digite o nome do prato para remoção do cardapio");
									scan.nextLine();
									nomePrato = scan.nextLine();
									if(meuSistema.recuperarItemConsumivel(nomePrato).isVisivel() == true)
									{
										meuSistema.removerDoCardapio(meuSistema.recuperarItemConsumivel(nomePrato));
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
									scan.nextLine();
									String nome = scan.nextLine();
									boolean gluten = false;
									boolean lactose = false;
									TipoCardapio tipoPrato = null;
									boolean visivel = false;
									
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
									
									System.out.println("Qual o tipo do prato? (1 = TRIVIAL | 2 = VEGANO | 3 = SUCO | 4 = SOBREMESA) ");

									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2 && sent != 3 && sent != 4)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2 && sent != 3 && sent != 4);
									
									switch(sent) {
									
									case 1:
										
										tipoPrato = TipoCardapio.TRIVIAL;
										break;
										
									case 2:
										
										tipoPrato = TipoCardapio.VEGANO;
										break;
										
									case 3:
										
										tipoPrato = TipoCardapio.SUCO;
										break;
										
									case 4:
										
										tipoPrato = TipoCardapio.SOBREMESA;
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
									meuSistema.adicionarItemConsumivel(nome, gluten, lactose, tipoPrato, visivel);
									break;
									
								case 2: 
									
									gluten = false;
									lactose = false;
									tipoPrato = null;
									visivel = false;
									
									System.out.println("Digite o nome do prato atual: ");
									do
									{
										scan.nextLine();
										nomeAtual = scan.nextLine();
									}while(nomeAtual == null);
									
									System.out.println("Digite o novo nome do prato: ");
									do
									{
										novoNome = scan.nextLine();
									}while(novoNome == null);
									
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
									
									System.out.println("Qual o tipo do prato? (1 = TRIVIAL | 2 = VEGANO | 3 = SUCO | 4 = SOBREMESA) ");

									do
									{
										sent = scan.nextInt();
										if(sent != 1 && sent != 2 && sent != 3 && sent != 4)
										{
											System.out.println("Operação invalida! Digite novamente");
										}
									}while(sent != 1 && sent != 2 && sent != 3 && sent != 4);
									
									switch(sent) {
									
									case 1:
										
										tipoPrato = TipoCardapio.TRIVIAL;
										break;
										
									case 2:
										
										tipoPrato = TipoCardapio.VEGANO;
										break;
										
									case 3:
										
										tipoPrato = TipoCardapio.SUCO;
										break;
										
									case 4:
										
										tipoPrato = TipoCardapio.SOBREMESA;
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
									
									meuSistema.atualizarItemConsumivel(nomeAtual, novoNome, gluten, lactose, tipoPrato, visivel);
									break;
									
								case 3: 
									
									System.out.println("Digite o nome do prato para ser removido: ");
									scan.nextLine();
									nome = scan.nextLine();
									
									meuSistema.removerItemConsumivel(nome);
									break;
									
								case 4:
									
									System.out.println(meuSistema.verTodosItemConsumiveis());
									break;
																
								}
								break;
								
							case 3:
								
								
								System.out.println(meuSistema.listarTodosUsuarios());
								
				
								
								System.out.println();
								System.out.println();
								
								System.out.println("Digite 1 para remover cliente || Digite 2 para remover Funcionário || Digite 3 para ver fichas || Digite 4 para sair");
								
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
									System.out.println("Digite o cpf do cliente que deseja remover: ");
									cpfCliente = scan.next();
									Cliente cliente = (Cliente) meuSistema.recuperarClienteEspecifico(cpfCliente);
									meuSistema.removerCliente(cpfCliente);
									System.out.println("Cliente: " + cliente + " foi removido");
									break;
									
								case 2: 
									System.out.println("Digite o cpf do funcionário que deseja remover: ");
									cpfFuncionario = scan.next();
									Funcionario funcionario = (Funcionario) meuSistema.recuperarFuncionarioEspecifico(cpfFuncionario);
									meuSistema.excluirFuncionario(cpfFuncionario);
									System.out.println("Funcionario: " + funcionario + " foi demitido!");
								
									if(cpfFuncionario.equals(cpf)) {
										saida = true;
									}
									break;
								case 3:
									System.out.println("Digite o mes(em Inteiro)");
									int mes = scan.nextInt();
									
									System.out.println(meuSistema.fichaPorMes(mes));
									break;
								case 4:
									
									break;
								}

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
						
						meuSistema.recuperarClienteEspecifico(cpf);
						
						do {				
							
							System.out.println("Digite 1 para comprar Ficha || Digite 2 para gastar ficha || Digite 3 para adiconar saldo|| Digite 4 para acessar o cardapio || Digite 5 acessar seu perfil "
												+ "|| Digite 6 para sair");
							do
							{
								sent = scan.nextInt();
								if(sent != 1 && sent != 2 && sent != 3 && sent != 4 && sent != 5 && sent != 6)
								{
									System.out.println("Operação invalida! Digite novamente");
								}
							}while(sent != 1 && sent != 2 && sent != 3 && sent != 4 && sent != 5 && sent != 6);
							
							switch(sent) {
							
							case 1:
								
								
								
								System.out.println("Digite o numero de fichas que deseja comprar");
								do
								{
									numeroFichas = scan.nextInt();
								}while(numeroFichas <= 0);				
								
								 if(meuSistema.recuperarClienteEspecifico(cpf) != null) {
									 System.out.println(meuSistema.recuperarClienteEspecifico(cpf));
									 System.out.println(Ficha.getPreco());
									 meuSistema.adicionarFicha(Ficha.getPreco(), numeroFichas*Ficha.getPreco() ,meuSistema.recuperarClienteEspecifico(cpf));
								 }
								
								 //System.out.println(meuSistema.listarFichaPorCliente(meuSistema.recuperarClienteEspecifico(cpf)));
								 break;
								 
							case 2:
								boolean out = false;
								
								do {
									System.out.println("Digite 1 inserir prato na refeicao || Digite 2 para finalizar preenchimento");
									int luizbobao = scan.nextInt();
									scan.nextLine();
									switch(luizbobao) {
									case 1:
										System.out.println("Digite o nome do prato: ");
										String AdicionarPrato = scan.nextLine();
										//meuSistema.adicionarItemConsumivelRefeicao(AdicionarPrato);
										break;
									case 2:
										out = true;
									}
									
									
								}while(!out);
								//meuSistema.gastarFicha(meuSistema.recuperarFichaDoCliente(meuSistema.recuperarClienteEspecifico(cpf)),meuSistema.listarRefeicao());
								System.out.println("Entrada no RU liberada");
								break;
								 
							case 3:
								
								System.out.println("Digite o valor do PIX (obs: sem casa decimal!)");
								do
								{
									valor = scan.nextInt();
								}while(valor <= 0);					
								
								meuSistema.depositar(valor, cpf);
								System.out.println(meuSistema.procurarClienteEspecifico(cpf));
								break;
								
							case 4:
								
								System.out.println("Cardapio:");
								System.out.println(meuSistema.cardapio());
								break;
								
							case 5:
								
								System.out.println(meuSistema.recuperarClienteEspecifico(cpf));
								
								System.out.println("Digite 1 para atualizar seu perfil || Digite 2 para remover sua conta || Digite 3 para visualizar suas fichas");
								
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
									System.out.println("Digite seu CPF");
									cpf = scan.next();
									
									System.out.println("Digite da seguinte forma: primeiroNome ultimoNome login senha");
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
										login = scan.next();
									}while(login == null);	
									do
									{
										senha = scan.next();
									}while(senha == null);	
									
									meuSistema.atualizarCliente(cpf, primeiroNome, ultimoNome, login, senha);
									System.out.println("Conta atualizada: "+meuSistema.procurarClienteEspecifico(cpf));
									break;
								
								case 2:
									System.out.println("Digite seu CPF");
									cpf = scan.next();
									
									
									meuSistema.removerCliente(cpf);
									System.out.println("É uma pena que você está indo embora ;-; ");
									saida = true;
									break;
									
								case 3:
									System.out.println(meuSistema.numeroDeFichaPorCliente(meuSistema.recuperarClienteEspecifico(cpf)));
									System.out.println(meuSistema.listarFichaPorCliente(meuSistema.recuperarClienteEspecifico(cpf)));
								}
							
								break;
							case 6:
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
		
						System.out.println(meuSistema.listarFuncionarioEspecifico(cpf));
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
						System.out.println(meuSistema.recuperarClienteEspecifico(cpf));
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

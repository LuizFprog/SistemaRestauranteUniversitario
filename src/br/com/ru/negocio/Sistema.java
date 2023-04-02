package br.com.ru.negocio;

import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.ItemConsumivel;
import br.com.ru.negocio.models.ItemConsumivel.TipoCardapio;
import br.com.ru.negocio.models.Usuario;

public class Sistema {
	
	private ControladorUsuario controladorUsuario;
	private ControladorItemConsumivel controladorItemConsumivel;
	private ControladorFicha controladorFicha;
	private static Sistema instancia;
	
	public Sistema()
	{
		this.controladorUsuario = ControladorUsuario.getInstancia();
		this.controladorItemConsumivel = ControladorItemConsumivel.getInstancia();
		this.controladorFicha = ControladorFicha.getInstancia();
	}
	
	// Garantir unica instancia da classe
	public static Sistema getInstancia()
	{
		if(instancia == null)
		{
			instancia = new Sistema();
		}
		return instancia;
	}	
	
	// Metodos Cliente
	
	// Você deve passar os parametros e esse metodo chamara um metodo para adicionar um cliente inicializado com tais 
	// parametros ao repositorio
	public void adicionarCliente(String primeiroNome, String ultimoNome,
			String cpf, String login, String senha) throws ElementoJaExisteException
	{
		controladorUsuario.criarCliente(primeiroNome, ultimoNome, cpf, login, senha);
	}
	// Procura Cliente atraves de cpf passado como parametro e retorna uma string para listar esse cliente
	public String procurarClienteEspecifico(String cpf) throws ElementoNaoExisteException
	{
		return controladorUsuario.listarClienteEspecifico(cpf);
	}
	
	// Procura Cliente atraves de cpf passado como parametro e retorna o objeto desse cliente
	public Usuario recuperarClienteEspecifico(String cpf) throws ElementoNaoExisteException
	{
		return controladorUsuario.recuperarUsuario(cpf);
	}
	
	// Procura o cliente atraves do cpf e o atualiza com os parametros passados
	public void atualizarCliente(String cpfAtual ,String primeiroNome, 
			String ultimoNome, String login, String senha) throws ElementoNaoExisteException
	{
		controladorUsuario.atualizarCliente(cpfAtual, primeiroNome, ultimoNome, login, senha);
	}
	
	// Procura o cliente atraves do cpf e o remove do repositorio
	public void removerCliente(String cpf) throws ElementoNaoExisteException
	{
		controladorUsuario.excluirCliente(cpf);
	}
	
	// Deposita um valor passado como parametro em uma conta com o cpf colocado como parametro
	public void depositar(double valor, String cpf) throws ElementoNaoExisteException
	{
		controladorUsuario.depositarDinheiro(valor, cpf);
	}
	
	// Debita um valor passado como parametro em uma conta com o cpf colocado como parametro, 
	// apenas se o valor for menor que o saldo do cliente
	public void debitar(double valor, String cpf) throws ElementoNaoExisteException
	{
		controladorUsuario.debitarDinheiro(valor, cpf);
	}
	
	// Metodos Funcionario
	
	
	// Recebe um cpf e retorna uma String do cliente que possui o cpf
	public String listarFuncionarioEspecifico(String cpf) throws ElementoNaoExisteException {
		
		
		return controladorUsuario.listarTrabalhadorEspecifico(cpf);
	}
	
	// Retorna apenas os clientes do repositorio de usuarios
	public List<Cliente> listarTodosClientes(){
		 return controladorUsuario.listarTodosClientes();
	}
	
	// Retorna apenas os funcionarios do repositorio de usuarios
	public List<Funcionario> listarTodosFuncionarios(){
		 return controladorUsuario.listarTodosFuncionarios();
	}
	
	// Retorna todos os usuarios
	public List<Usuario> listarTodosUsuarios(){
		return controladorUsuario.listarUsuarios();
	}
	
	// Inicializa um funcionario com os parametros passados
	public void adicionarFuncionario(String primeiroNome, String ultimoNome,
			String cpf, String login, String senha, String id) throws ElementoJaExisteException
	{
		controladorUsuario.adicionarFuncionario(primeiroNome, ultimoNome, cpf, login, senha, id);
	}
	
	// Retorna um usuario que possua o cpf passado como parametro
	public Usuario recuperarFuncionarioEspecifico(String cpf) throws ElementoNaoExisteException {
		
		return controladorUsuario.recuperarFuncionario(cpf);
	}
	
	// Atualiza um funcionario que possua o cpf passado como parametro com as informações, também passadas como parametro
	public void atualizarFuncionario(String cpfAtual, String primeiroNome, String ultimoNome, String login, String senha, String id) 
			throws ElementoNaoExisteException
	{
		controladorUsuario.atualizarFuncionario(cpfAtual, primeiroNome, ultimoNome, login, senha, id);
	}
	
	
	// Exclui um funcionario que possua o cpf passado como parametro
	public void excluirFuncionario(String cpf) throws ElementoNaoExisteException
	{
		controladorUsuario.excluirFuncionario(cpf);
	}
	
	// Metodos ItemConsumivel
	
	
	// Adiciona um itemConsumivel com as informações passadas como parametro
	public void adicionarItemConsumivel(String nome, 
			boolean gluten, boolean lactose, TipoCardapio tipoItemConsumivel, boolean visivel) 
			throws ElementoJaExisteException
	{
		controladorItemConsumivel.adicionarItemConsumivel(nome, gluten, lactose, tipoItemConsumivel, visivel);
	}
	
	
	// Retorna os itemConsumivels que aparecem no cardapio
	public List<ItemConsumivel> cardapio()
	{
		return controladorItemConsumivel.mostrarCardapio();
	}
	
	// Retorna todos os itemConsumivels
	public List<ItemConsumivel> verTodosItemConsumivels()
	{
		return controladorItemConsumivel.listarTodosItemConsumiveis();
	}
	
	public List<ItemConsumivel> cardapioTrivial()
	{
		return controladorItemConsumivel.cardapioTrivial();
	}
	
	public List<ItemConsumivel> cardapioVegano()
	{
		return controladorItemConsumivel.cardapioVegano();
	}
	
	public List<ItemConsumivel> cardapioSuco()
	{
		return controladorItemConsumivel.cardapioSuco();
	}
	
	public List<ItemConsumivel> cardapioSobremesa()
	{
		return controladorItemConsumivel.cardapioSobremesa();
	}
	
	// Adiciona itemConsumivel a refeição
	public void adicionarItemConsumivelRefeicao(String nomeItemConsumivel) throws ElementoJaExisteException, ElementoNaoExisteException
	{
		controladorItemConsumivel.adicionarItemConsumivelNaRefeicao(nomeItemConsumivel);
	}
	
	// Remover itemConsumivel da refeição
	public void removerItemConsumivelRefeicao(String nomeItemConsumivel) throws ElementoNaoExisteException
	{
		controladorItemConsumivel.removerItemConsumivelDaRefeicao(nomeItemConsumivel);
	}
	
	// Listar itemConsumivels da refeição
	public List<ItemConsumivel> listarRefeicao()
	{
		return controladorItemConsumivel.listarRefeicao();
	}
	
	// Retorna a refeição para o valor padrão
	public void resetarRefeicao()
	{
		controladorItemConsumivel.resetarRefeicao();
	}
	
	// Atualiza itemConsumivel que possua o nomeAtual passado como parametro com as informações, também passadas como parametro
	public void atualizarItemConsumivel(String nomeAtual, String nome, 
			boolean gluten, boolean lactose, TipoCardapio tipoItemConsumivel, boolean visivel) 
					throws ElementoNaoExisteException
	{
		controladorItemConsumivel.atualizarItemConsumivel(nomeAtual, nome, gluten, lactose, tipoItemConsumivel, visivel);
	}
	
	// Remove um itemConsumivel com o nome passado como parametro do repositorio
	public void removerItemConsumivel(String nome) throws ElementoNaoExisteException
	{
		controladorItemConsumivel.removerItemConsumivel(nome);
	}
	
	// Retorna um itemConsumivel que possui o nome passado como parametro
	public ItemConsumivel recuperarItemConsumivel(String nome) throws ElementoNaoExisteException
	{
		return controladorItemConsumivel.recuperarItemConsumivel(nome);
	}
	
	// Adiciona um itemConsumivel passado como parametro ao cardapio
	public void colocarNoCardapio(ItemConsumivel itemConsumivel) throws ElementoNaoExisteException
	{
		controladorItemConsumivel.itemConsumivelVisivel(itemConsumivel);
	}
	
	// Remove um itemConsumivel passado como parametro do cardapio
	public void removerDoCardapio(ItemConsumivel itemConsumivel) throws ElementoNaoExisteException
	{
		controladorItemConsumivel.itemConsumivelNaoVisivel(itemConsumivel);
	}
	
	// Metodos Ficha
	
	// Adiciona uma ficha com as informações passadas como parametro
	public void adicionarFicha(double preco, double dinheiroCliente, Usuario cliente) 
			throws ElementoJaExisteException, SaldoInsuficienteException
	{
		if(cliente instanceof Cliente)
		{
			controladorFicha.comprarFicha(preco, dinheiroCliente, (Cliente)cliente);
		}
	}
	
	// Retorna uma lista de todas as fichas
	public List<Ficha> listarFicha()
	{
		return controladorFicha.listarFichas();
	}
	
	//Listar por periodo
	public List<Ficha> fichaPorPeriodo(int mes){
		return controladorFicha.listarFichaPorPeriodo(mes);
	}
	
	
	// Retorna uma lista de todas as fichas do cliente passado como parametro
	public List<Ficha> listarFichaPorCliente(Usuario cliente) throws ElementoNaoExisteException
	{
		if(cliente instanceof Cliente)
		{
			return controladorFicha.listarFichaPorCliente((Cliente) cliente);
		}
		return null;
	}
	
//	// Retorna a lista com todas as fichas da mais nova a mais antiga
//	public List<Ficha> listarFichaRecente()
//	{
//		return controladorFicha.listarFichasRecentes();
//	}
	
	// Gasta ficha para liberar o acesso ao RU
	public void gastarFicha(Ficha ficha, List<ItemConsumivel> refeicao) throws ElementoNaoExisteException
	{
		controladorFicha.gastarFicha(ficha, refeicao);
	}
	
	// Recupera ficha especifica do cliente
	public Ficha recuperarFichaDoCliente(Usuario cliente) throws ElementoNaoExisteException
	{
		if(cliente instanceof Cliente)
		{
			return controladorFicha.recuperarFichaDoCliente((Cliente) cliente);
		}
		return null;
	}
	
	// Retorna o número de fichas do cliente
	public int numeroDeFichaPorCliente(Usuario cliente) throws ElementoNaoExisteException
	{
		if(cliente instanceof Cliente)
		{
			return controladorFicha.numeroDeFichaPorCliente((Cliente)cliente);
		}
		return 0;
	}
	
	// Atualiza o preço da ficha
	public void atualizarPrecoFicha(double preco)
	{
		controladorFicha.atualizarPrecoFicha(preco);
	}
}

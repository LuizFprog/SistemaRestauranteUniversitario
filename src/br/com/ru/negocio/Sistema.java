package br.com.ru.negocio;

import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.Prato;
import br.com.ru.negocio.models.Usuario;

public class Sistema {
	
	private ControladorUsuario controladorUsuario;
	private ControladorPrato controladorPrato;
	private ControladorFicha controladorFicha;
	private static Sistema instancia;
	
	public Sistema()
	{
		this.controladorUsuario = ControladorUsuario.getInstance();
		this.controladorPrato = ControladorPrato.getInstancia();
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
	public void adicionarCliente(String primeiroNome, String ultimoNome,
			String cpf, String login, String senha) throws ElementoJaExisteException
	{
		controladorUsuario.criarCliente(primeiroNome, ultimoNome, cpf, login, senha);
	}
	
	public String procurarClienteExpecifico(String cpf) throws ElementoNaoExisteException
	{
		return controladorUsuario.listarClienteEspecifico(cpf);
	}
	
	public Usuario recuperarClienteExpecifico(String cpf) throws ElementoNaoExisteException
	{
		return controladorUsuario.recuperarUsuario(cpf);
	}
	
	public void atualizarCliente(String cpfAtual ,String primeiroNome, 
			String ultimoNome,String cpf,String login, String senha) throws ElementoNaoExisteException
	{
		controladorUsuario.atualizarCliente(cpfAtual, primeiroNome, ultimoNome, cpf, login, senha);
	}
	
	public void removerCliente(String cpf) throws ElementoNaoExisteException
	{
		controladorUsuario.excluirCliente(cpf);
	}
	
	public void depositar(double valor, String cpf) throws ElementoNaoExisteException
	{
		controladorUsuario.depositarDinheiro(valor, cpf);
	}
	
	public void debitar(double valor, String cpf) throws ElementoNaoExisteException
	{
		controladorUsuario.debitarDinheiro(valor, cpf);
	}
	
	// Metodos Funcionario
	
	public String listarFuncionarioEspecifico(String cpf) throws ElementoNaoExisteException {
		
		
		return controladorUsuario.listarEscravoEspecifico(cpf);
	}
	
	public List<Cliente> listarTodosClientes(){
		 return controladorUsuario.listarTodosClientes();
	}
	
	public List<Funcionario> listarTodosFuncionarios(){
		 return controladorUsuario.listarTodosFuncionarios();
	}
	
	public List<Usuario> listarTodosUsuarios(){
		return controladorUsuario.listarUsuarios();
	}
	
	public void adicionarFuncionario(String primeiroNome, String ultimoNome,
			String cpf, String login, String senha, String id) throws ElementoJaExisteException
	{
		controladorUsuario.adicionarFuncionario(primeiroNome, ultimoNome, cpf, login, senha, id);
	}
	
	public List<Usuario> listarFuncionarios()
	{
		return controladorUsuario.listarUsuarios();
	}
	
	public void atualizarFuncionario(String cpfAtual, String primeiroNome, String ultimoNome, String cpf, String login, String senha, String id) 
			throws ElementoNaoExisteException
	{
		controladorUsuario.atualizarFuncionario(cpfAtual, primeiroNome, ultimoNome, cpf, login, senha, id);
	}
	
	public void excluirFuncionario(String cpf) throws ElementoNaoExisteException
	{
		controladorUsuario.excluirFuncionario(cpf);
	}
	
	// Metodos Prato
	
	public void adicionarPrato(String nome, boolean vegano, boolean gluten, 
			boolean lactose, boolean suco, boolean sobremesa, boolean visivel) 
			throws ElementoJaExisteException
	{
		controladorPrato.adicionarPrato(nome, vegano, gluten, lactose, suco, sobremesa, visivel);
	}
	
	public List<Prato> cardapio()
	{
		return controladorPrato.mostrarCardapio();
	}
	
	public List<Prato> verTodosPratos()
	{
		return controladorPrato.listarTodosPratos();
	}
	
	public void atualizarPrato(String nomeAtual, String nome, boolean vegano, 
			boolean gluten, boolean lactose, boolean suco, boolean sobremesa, boolean visivel) 
					throws ElementoNaoExisteException
	{
		controladorPrato.atualizarPrato(nomeAtual, nome, vegano, gluten, lactose, suco, sobremesa, visivel);
	}
	
	public void removerPrato(String nome) throws ElementoNaoExisteException
	{
		controladorPrato.removerPrato(nome);
	}
	
	public Prato recuperarPrato(String nome) throws ElementoNaoExisteException
	{
		return controladorPrato.recuperarPrato(nome);
	}
	
	public void colocarNoCardapio(Prato prato) throws ElementoNaoExisteException
	{
		controladorPrato.pratoVisivel(prato);
	}
	
	public void removerDoCardapio(Prato prato) throws ElementoNaoExisteException
	{
		controladorPrato.pratoNaoVisivel(prato);
	}
	
	// Metodos Ficha
	public void adicionarFicha(double preco, double dinheiroCliente, Usuario cliente) 
			throws ElementoJaExisteException, SaldoInsuficienteException
	{
		if(cliente instanceof Cliente)
		{
			controladorFicha.comprarFicha(preco, dinheiroCliente, (Cliente)cliente);
		}
	}
	
	public List<Ficha> listarFicha()
	{
		return controladorFicha.listarFichas();
	}
	
	public List<Ficha> listarFichaPorCliente(Usuario cliente) throws ElementoNaoExisteException
	{
		if(cliente instanceof Cliente)
		{
			return controladorFicha.listarFichaPorCliente((Cliente) cliente);
		}
		return null;
	}
	
	public List<Ficha> listarFichaRecente()
	{
		return controladorFicha.listarFichasRecentes();
	}
	
	public void gastarFicha(Ficha ficha) throws ElementoNaoExisteException
	{
		controladorFicha.gastarFicha(ficha);
	}
	
	public Ficha recuperarFichaDoCliente(Usuario cliente) throws ElementoNaoExisteException
	{
		if(cliente instanceof Cliente)
		{
			return controladorFicha.recuperarFichaDoCliente((Cliente) cliente);
		}
		return null;
	}
}

package br.com.ru.negocio;

import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.Prato;

public class Sistema {
	
	private ControladorCliente controladorCliente;
	private ControladorFuncionario controladorFuncionario;
	private ControladorPrato controladorPrato;
	private static Sistema instancia;
	
	public Sistema()
	{
		this.controladorCliente = ControladorCliente.getInstancia();
		this.controladorFuncionario = ControladorFuncionario.getInstance();
		this.controladorPrato = ControladorPrato.getInstancia();
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
		controladorCliente.criarCliente(primeiroNome, ultimoNome, cpf, login, senha);
	}
	
	public String procurarClienteExpecifico(String cpf) throws ElementoNaoExisteException
	{
		return controladorCliente.listarClienteEspecifico(cpf);
	}
	
	public void atualizarCliente(String cpfAtual ,String primeiroNome, 
			String ultimoNome,String cpf,String login, String senha) throws ElementoNaoExisteException
	{
		controladorCliente.atualizarCliente(cpfAtual, primeiroNome, ultimoNome, cpf, login, senha);
	}
	
	public void removerCliente(String cpf) throws ElementoNaoExisteException
	{
		controladorCliente.excluirCliente(cpf);
	}
	
	// Metodos Funcionario
	
	public void adicionarFuncionario(String primeiroNome, String ultimoNome,
			String cpf, String login, String senha, String id) throws ElementoJaExisteException
	{
		controladorFuncionario.adicionarFuncionario(primeiroNome, ultimoNome, cpf, login, senha, id);
	}
	
	public List<Funcionario> listarFuncionarios()
	{
		return controladorFuncionario.listarFuncionarios();
	}
	
	public void atualizarFuncionario(String cpfAtual, String primeiroNome, String ultimoNome, String cpf, String login, String senha, String id) 
			throws ElementoNaoExisteException
	{
		controladorFuncionario.atualizarFuncionario(cpfAtual, primeiroNome, ultimoNome, cpf, login, senha, id);
	}
	
	public void excluirFuncionario(String cpf) throws ElementoNaoExisteException
	{
		controladorFuncionario.excluirFuncionario(cpf);
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
}

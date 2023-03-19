package br.com.ru.negocio;

import java.util.List;

import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioCliente;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Cliente;

public class ControladorCliente {

	private IRepositorioGenerico<Cliente> repositorioClientes;
	private List<Cliente> listaClientes;

	public ControladorCliente() {
		this.repositorioClientes = new RepositorioCliente(listaClientes);
	}
	
	
	// Método para criar um novo cliente
	public void criarCliente(String primeiroNome, String ultimoNome, String cpf, String login, String senha) throws ElementoJaExisteException {
		
		List<Cliente> clientes = repositorioClientes.read();
		for (Cliente c : clientes) {
			if (c.getCpf().equals(cpf) || c.getLogin().equals(login)) {
				throw new ElementoJaExisteException("Já existe um cliente com o mesmo CPF ou login!");
			}
		}
		Cliente novo_cliente = new Cliente(primeiroNome, ultimoNome, cpf, login, senha);
		
		repositorioClientes.add(novo_cliente);
	}
	
	public String listarClienteEspecifico(String cpf) throws ElementoNaoExisteException {
		
		Cliente c = recuperarCliente(cpf);
		
		String clienteListado = c.toString();
		
		return clienteListado;
		}


	// Método para recuperar um cliente
	public Cliente recuperarCliente(String cpf) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		List<Cliente> clientes = repositorioClientes.read();
		for (Cliente c : clientes) {
			if (c.getCpf().equals(cpf)) {
				return c;
			}
		}
		// Caso não encontre, lança exceção
		throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
	}

	
	// Método para atualizar um cliente
	public void atualizarCliente(String cpfAtual ,String primeiroNome, String ultimoNome,String cpf,String login, String senha) throws ElementoNaoExisteException
								{
		
		Cliente clienteAtual = recuperarCliente(cpfAtual);
		
		Cliente novo = new Cliente(primeiroNome, ultimoNome, cpf, login, senha);
		repositorioClientes.update(clienteAtual, novo);
	}
	

	// Método para excluir um cliente
	public void excluirCliente(String cpf) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		Cliente cliente = recuperarCliente(cpf);
		// Remove o cliente do repositório
		repositorioClientes.remove(cliente);
	}
}

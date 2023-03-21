//package br.com.ru.negocio;
//
//import java.util.List;
//
//import br.com.ru.dados.IRepositorioGenerico;
//import br.com.ru.dados.RepositorioCliente;
//import br.com.ru.dados.RepositorioUsuario;
//import br.com.ru.exceptions.ElementoJaExisteException;
//import br.com.ru.exceptions.ElementoNaoExisteException;
//import br.com.ru.negocio.models.Cliente;
//import br.com.ru.negocio.models.Usuario;
//
//public class ControladorCliente extends ControladorUsuario{
//
//	private IRepositorioGenerico<Cliente> repositorioClientes;
//	private List<Cliente> listaClientes;
//	private static ControladorCliente instancia;
//
//	public ControladorCliente() {
//		this.repositorioClientes = new RepositorioCliente(listaClientes);
//	}
//	
//	// Garantir unica instancia da classe
//	public static ControladorCliente getInstancia()
//	{
//		if(instancia == null)
//		{
//			instancia = new ControladorCliente();
//		}
//		return instancia;
//	}	
//	
//	
//	// Método para criar um novo cliente
//	public void criarCliente(String primeiroNome, String ultimoNome, String cpf, String login, String senha) throws ElementoJaExisteException {
//		
//		List<Usuario> usuarios = repositorioUsuario.ler();
//		
//		for (Usuario c : usuarios) {
//			if (c.getCpf().equals(cpf) || c.getLogin().equals(login)) {
//				throw new ElementoJaExisteException("Já existe um cliente com o mesmo CPF ou login!");
//			}
//		}
//		
//		if (primeiroNome != null && ultimoNome != null && cpf != null && login != null && senha != null) {
//			
//			
//			Cliente novo_cliente = new Cliente(primeiroNome, ultimoNome, cpf, login, senha);
//			repositorioClientes.inserir(novo_cliente);
//			repositorioUsuario.inserir(novo_cliente);
//		}	
//		
//	
//	}
//	
//	public String listarClienteEspecifico(String cpf) throws ElementoNaoExisteException {
//		
//		Usuario c = recuperarCliente(cpf);
//		
//		String clienteListado = c.toString();
//		System.out.println(clienteListado);
//		return clienteListado;
//		}
//
//
//	// Método para recuperar um cliente
//	public Cliente recuperarCliente(String cpf) throws ElementoNaoExisteException {
//		// Busca o cliente pelo CPF
//		List<Cliente> clientes = repositorioClientes.ler();
//		for (Cliente c : clientes) {
//			if (c.getCpf().equals(cpf)) {
//				return c;
//			}
//		}
//		// Caso não encontre, lança exceção
//		throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
//	}
//
//	
//	// Método para atualizar um cliente
//	public void atualizarCliente(String cpfAtual ,String primeiroNome, String ultimoNome,String cpf,String login, String senha) throws ElementoNaoExisteException
//								{
//		
//		Cliente clienteAtual = recuperarCliente(cpfAtual);
//		
//		Cliente novo = new Cliente(primeiroNome, ultimoNome, cpf, login, senha);
//		repositorioUsuario.atualizar(clienteAtual, novo);
//		repositorioClientes.atualizar(clienteAtual, novo);
//		
//	}
//	
//
//	// Método para excluir um cliente
//	public void excluirCliente(String cpf) throws ElementoNaoExisteException {
//		// Busca o cliente pelo CPF
//		Cliente cliente = recuperarCliente(cpf);
//		// Remove o cliente do repositório
//		repositorioUsuario.remover(cliente);
//		repositorioClientes.remover(cliente);
//	}
//}

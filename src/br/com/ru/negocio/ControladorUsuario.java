package br.com.ru.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioUsuario;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.Usuario;

public class ControladorUsuario {

	protected IRepositorioGenerico<Usuario> repositorioUsuario;
	private static ControladorUsuario instancia;
	private List<Usuario> listaUsuario;
	

	private ControladorUsuario() {
		this.repositorioUsuario = new RepositorioUsuario(listaUsuario);
	}
	
	public static ControladorUsuario getInstancia() {
		if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
	}
	
	//Método para criar um novo cliente
	public void criarCliente(String primeiroNome, String ultimoNome, String cpf, String login, String senha) throws ElementoJaExisteException {
		
		List<Usuario> usuarios = repositorioUsuario.ler();
		
		for (Usuario c : usuarios) {
			if (c.getCpf().equals(cpf) || c.getLogin().equals(login)) {
				throw new ElementoJaExisteException("Já existe um cliente com o mesmo CPF ou login!");
			}
		}
		
		if (primeiroNome != null && ultimoNome != null && cpf != null && login != null && senha != null) {
			
			
			Cliente novo_cliente = new Cliente(primeiroNome, ultimoNome, cpf, login, senha, 0);
			repositorioUsuario.inserir(novo_cliente);
		}	
		
	
	}
	
	public String listarTrabalhadorEspecifico(String cpf) throws ElementoNaoExisteException {
		
		Usuario c = recuperarUsuario(cpf);
		
		if(c instanceof Funcionario) {
			String funcionarioListado = c.toString();
			return funcionarioListado;
		}
		
		return null;
	}
	
	public List<Cliente> listarTodosClientes(){
		
		List<Usuario> atual = repositorioUsuario.ler();
		List<Cliente> nova = new ArrayList<>();
		
		for(Usuario c : atual) {
			
			if(c instanceof Cliente) {
				nova.add((Cliente) c);
			}
		}
	
		return nova;
	}
	
	public List<Funcionario> listarTodosFuncionarios(){
		
		List<Usuario> atual = repositorioUsuario.ler();
		List<Funcionario> nova = new ArrayList<>();
		
		for(Usuario f : atual) {
			
			if(f instanceof Funcionario) {
				nova.add((Funcionario) f);
			}
		}
	
		return nova;
	}
	
	public String listarClienteEspecifico(String cpf) throws ElementoNaoExisteException {
		
		Usuario c = recuperarUsuario(cpf);
		
		String clienteListado = c.toString();
		return clienteListado;
		}


	// Método para recuperar um cliente
	public Usuario recuperarUsuario(String cpf) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		List<Usuario> clientes = repositorioUsuario.ler();
		for (Usuario c : clientes) {
			if (c.getCpf().equals(cpf)) {
				return c;
			}
		}
		// Caso não encontre, lança exceção
		throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
	}
	
	// Método para recuperar um cliente por login e senha
		public Usuario recuperarLoginSenha(String login, String senha) throws ElementoNaoExisteException {
			// Busca o cliente pelo CPF
			List<Usuario> clientes = repositorioUsuario.ler();
			for (Usuario c : clientes) {
				if (c.getLogin().equals(login) && c.getSenha().equals(senha)) {
					return c;
				}
			}
			// Caso não encontre, lança exceção
			throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
		}

	
	// Método para atualizar um cliente
	public void atualizarCliente(String cpfAtual ,String primeiroNome, String ultimoNome,String login, String senha) throws ElementoNaoExisteException
								{
		
		Cliente clienteAtual = (Cliente) recuperarUsuario(cpfAtual);
		
		Cliente novo = new Cliente(primeiroNome, ultimoNome, clienteAtual.getCpf(), login, senha, clienteAtual.getSaldo());
		repositorioUsuario.atualizar(clienteAtual, novo);	
	}
	
	public void depositarDinheiro(double valor, String cpf) throws ElementoNaoExisteException
	{
		Cliente clienteAtual = (Cliente) recuperarUsuario(cpf);
		clienteAtual.depositar(valor);
	}
	
	public void debitarDinheiro(double valor, String cpf) throws ElementoNaoExisteException
	{
		Cliente clienteAtual = (Cliente) recuperarUsuario(cpf);
		clienteAtual.debitar(valor);
	}
	

	// Método para excluir um cliente
	public void excluirCliente(String cpf) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		Cliente cliente = (Cliente) recuperarUsuario(cpf);
		// Remove o cliente do repositório
		repositorioUsuario.remover(cliente);
	}
	
	// Metodo para adicionar Funcionario
	public void adicionarFuncionario(String primeiroNome, String ultimoNome, String cpf, String login, String senha, String id) throws ElementoJaExisteException {
		
		List<Usuario> usuarios = repositorioUsuario.ler();
		
		for (Usuario c : usuarios) {
			if (c.getCpf().equals(cpf) || c.getLogin().equals(login)){
				throw new ElementoJaExisteException("Já existe um usuario com o mesmo CPF ou login!");
			}
			if(c instanceof Funcionario && ((Funcionario)c).getId().equals(id))
			{
				throw new ElementoJaExisteException("Já existe um funcionario com o mesmo id");
			}
		}
		
		if (primeiroNome != null && ultimoNome != null && cpf != null && login != null && senha != null && id != null) {
			Funcionario novo = new Funcionario(primeiroNome, ultimoNome, cpf, login, senha, id);
			repositorioUsuario.inserir(novo);
		}
		
	}
	
	public List<Usuario> listarUsuarios() {
	
        return repositorioUsuario.ler();
    }
	
	// Recuperar funcionario
	public Usuario recuperarFuncionario(String cpf) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		List<Usuario> funcionarios = repositorioUsuario.ler();
		for (Usuario f : funcionarios) {
			if (f.getCpf().equals(cpf)) {
				return f;
			}
		}
		// Caso não encontre, lança exceção
		throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
	}
	
	public void excluirFuncionario(String cpf) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		Funcionario funcionario = (Funcionario) recuperarUsuario(cpf);
		// Remove o cliente do repositório	
		repositorioUsuario.remover(funcionario);
		
	}
	
	public void atualizarFuncionario (String cpfAtual, String primeiroNome, String ultimoNome, String login, String senha, String id) 
					throws ElementoNaoExisteException {
		
		Funcionario funcionarioAtual = (Funcionario) recuperarUsuario(cpfAtual);
		
		Funcionario novo = new Funcionario(primeiroNome, ultimoNome, funcionarioAtual.getCpf(), login, senha, id);
		repositorioUsuario.atualizar(funcionarioAtual, novo);
		
	}
}

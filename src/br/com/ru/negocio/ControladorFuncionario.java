package br.com.ru.negocio;

import java.util.List;

import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.dados.RepositorioGenerico;


public class ControladorFuncionario {
	private IRepositorioGenerico<Funcionario> repositorioFuncionario;
	private static ControladorFuncionario instancia;
	private List<Funcionario> listaFuncionario;
	
	public ControladorFuncionario() {
		this.repositorioFuncionario = new RepositorioGenerico<Funcionario>(listaFuncionario);
	}
	
	public static ControladorFuncionario getInstance() {
		if (instancia == null) {
            instancia = new ControladorFuncionario();
        }
        return instancia;
	}
	
	public void adicionarFuncionario(String primeiroNome, String ultimoNome, String cpf, String login, String senha, String id) 
		throws ElementoJaExisteException {
		
		Funcionario novo = new Funcionario(primeiroNome, ultimoNome, cpf, login, senha, id);
		repositorioFuncionario.inserir(novo);
		
	}
	
	public List<Funcionario> listar() {
        return repositorioFuncionario.ler();
    }
	
	public void removerFuncionario (Funcionario removeFuncionario) 
			throws ElementoNaoExisteException
	{
		repositorioFuncionario.remover(removeFuncionario);
	}
	
<<<<<<< HEAD
	public void atualizarFuncionario (Funcionario atual, String primeiroNome, String ultimoNome, String cpf, String login, String senha, String id) 
=======
	public Funcionario recuperarFuncionario(String cpf) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		List<Funcionario> funcionarios = repositorioFuncionario.ler();
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(cpf)) {
				return f;
			}
		}
		// Caso não encontre, lança exceção
		throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
	}
	
	public void excluirFuncionario(String cpf) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		Funcionario funcionario = recuperarFuncionario(cpf);
		// Remove o cliente do repositório
		repositorioFuncionario.remover(funcionario);
	}
	
	public void atualizarFuncionario (String cpfAtual, String primeiroNome, String ultimoNome, String cpf, String login, String senha, String id) 
>>>>>>> fe78b34302658df81c0e0f09ab41df93a2d0ff40
					throws ElementoNaoExisteException {
		
		Funcionario funcionarioAtual = recuperarFuncionario(cpfAtual);
		
		Funcionario novo = new Funcionario(primeiroNome, ultimoNome, cpf, login, senha, id);
		repositorioFuncionario.atualizar(funcionarioAtual, novo);
		
	}
	
}

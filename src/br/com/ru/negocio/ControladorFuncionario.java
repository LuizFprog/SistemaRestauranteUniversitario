package br.com.ru.negocio;

import java.util.List;

import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
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
	
	public void atualizarFuncionario (Funcionario atual, String primeiroNome, String ultimoNome, String cpf, String login, String senha, String id) 
					throws ElementoNaoExisteException {
		
		Funcionario novo = new Funcionario(primeiroNome, ultimoNome, cpf, login, senha, id);
		repositorioFuncionario.atualizar(atual, novo);
		
	}
	
}

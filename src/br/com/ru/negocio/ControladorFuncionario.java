//package br.com.ru.negocio;
//
//import java.util.List;
//
//import br.com.ru.dados.IRepositorioGenerico;
//import br.com.ru.dados.RepositorioFuncionario;
//import br.com.ru.exceptions.ElementoJaExisteException;
//import br.com.ru.exceptions.ElementoNaoExisteException;
//import br.com.ru.negocio.models.Funcionario;
//import br.com.ru.negocio.models.Usuario;
//
//
//public class ControladorFuncionario extends ControladorUsuario{
//	private IRepositorioGenerico<Funcionario> repositorioFuncionario;
//	private static ControladorFuncionario instancia;
//	private List<Funcionario> listaFuncionario;
//	
//	public ControladorFuncionario() {
//		this.repositorioFuncionario = new RepositorioFuncionario(listaFuncionario);
//	}
//	
//	public static ControladorFuncionario getInstance() {
//		if (instancia == null) {
//            instancia = new ControladorFuncionario();
//        }
//        return instancia;
//	}
//	
//	public void adicionarFuncionario(String primeiroNome, String ultimoNome, String cpf, String login, String senha, String id) throws ElementoJaExisteException {
//		
//		List<Usuario> usuarios = repositorioUsuario.ler();
//		
//		for (Usuario c : usuarios) {
//			if (c.getCpf().equals(cpf) || c.getLogin().equals(login)) {
//				throw new ElementoJaExisteException("Já existe um cliente com o mesmo CPF ou login!");
//			}
//		}
//		
//		if (primeiroNome != null && ultimoNome != null && cpf != null && login != null && senha != null && id != null) {
//			Funcionario novo = new Funcionario(primeiroNome, ultimoNome, cpf, login, senha, id);
//			repositorioFuncionario.inserir(novo);
//			repositorioUsuario.inserir(novo);
//		}
//		
//	}
//	
//	public List<Funcionario> listarFuncionarios() {
//	
//        return repositorioFuncionario.ler();
//    }
//	
//	public void removerFuncionario (Funcionario removeFuncionario) 
//			throws ElementoNaoExisteException
//	{
//		repositorioFuncionario.remover(removeFuncionario);
//		repositorioUsuario.remover(removeFuncionario);
//	}
//	
//	public Funcionario recuperarFuncionario(String cpf) throws ElementoNaoExisteException {
//		// Busca o cliente pelo CPF
//		List<Funcionario> funcionarios = repositorioFuncionario.ler();
//		for (Funcionario f : funcionarios) {
//			if (f.getCpf().equals(cpf)) {
//				return f;
//			}
//		}
//		// Caso não encontre, lança exceção
//		throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
//	}
//	
//	public void excluirFuncionario(String cpf) throws ElementoNaoExisteException {
//		// Busca o cliente pelo CPF
//		Funcionario funcionario = recuperarFuncionario(cpf);
//		// Remove o cliente do repositório
//		
//	
//		
//		repositorioUsuario.remover(funcionario);
//		repositorioFuncionario.remover(funcionario);
//		
//	}
//	
//	public void atualizarFuncionario (String cpfAtual, String primeiroNome, String ultimoNome, String cpf, String login, String senha, String id) 
//					throws ElementoNaoExisteException {
//		
//		Funcionario funcionarioAtual = recuperarFuncionario(cpfAtual);
//		
//		Funcionario novo = new Funcionario(primeiroNome, ultimoNome, cpf, login, senha, id);
//		repositorioFuncionario.atualizar(funcionarioAtual, novo);
//		repositorioUsuario.atualizar(funcionarioAtual, novo);
//		
//	}
//	
//}

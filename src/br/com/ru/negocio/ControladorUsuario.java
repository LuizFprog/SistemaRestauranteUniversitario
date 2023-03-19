package br.com.ru.negocio;

import java.util.List;

import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioUsuario;
import br.com.ru.negocio.models.Usuario;

public class ControladorUsuario {

	protected static IRepositorioGenerico<Usuario> repositorioUsuario;
	private static ControladorUsuario instancia;
	private List<Usuario> listaUsuario;
	

	public ControladorUsuario() {
		ControladorUsuario.repositorioUsuario = new RepositorioUsuario(listaUsuario);
	}
	
	public static ControladorUsuario getInstance() {
		if (instancia == null) {
            instancia = new ControladorFuncionario();
        }
        return instancia;
	}
	
	
	// Método para criar um novo cliente
//	public void criarUsuario(String primeiroNome, String ultimoNome, String cpf, String login, String senha) throws ElementoJaExisteException {
//		
//		List<Usuario> usuarios = repositorioUsuario.ler();
//		for (Usuario s : usuarios) {
//			if (s.getCpf().equals(cpf) || s.getLogin().equals(login)) {
//				throw new ElementoJaExisteException("Já existe um cliente com o mesmo CPF ou login!");
//			}
//		}
//		Usuario novo_cliente = new Cliente(primeiroNome, ultimoNome, cpf, login, senha);
//		
//		repositorioUsuario.inserir(novo_cliente);
//	}
	
	
	

}

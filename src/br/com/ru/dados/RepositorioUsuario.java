package br.com.ru.dados;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Usuario;

public class RepositorioUsuario implements IRepositorioGenerico<Usuario>{
	private List<Usuario> usuarios;

	public RepositorioUsuario(List<Usuario> clientes) {
		this.usuarios = new ArrayList<>();
	}

	@Override
	public void inserir(Usuario novo)throws ElementoJaExisteException{
		if(!this.usuarios.contains(novo))
		{
			usuarios.add(novo);
		}
		else
		{
			throw new ElementoJaExisteException(novo);
		}
	}

	@Override
	public List<Usuario> ler() {
		return Collections.unmodifiableList(usuarios);
	}

	@Override
	public void remover(Usuario cliente) throws ElementoNaoExisteException {
		if(this.usuarios.contains(cliente))
		{
			this.usuarios.remove(this.usuarios.indexOf(cliente));
		}
		else
		{
			throw new ElementoNaoExisteException(cliente);
		}
	}

	@Override

	public void atualizar(Usuario atual, Usuario novoConteudo) throws ElementoNaoExisteException {
		if(this.usuarios.contains(novoConteudo))

		{
			int indice = this.usuarios.indexOf(atual);
			this.usuarios.set(indice, novoConteudo);
		}
		else
		{
			throw new ElementoNaoExisteException(novoConteudo);
		}
	}
}
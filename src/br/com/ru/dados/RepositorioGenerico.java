package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;

public class RepositorioGenerico<T> implements IRepositorioGenerico<T>{
	private List<T> elementos;

	public RepositorioGenerico(List<T> elementos) {
		super();
		this.elementos = new ArrayList<>();
	}

	@Override
	public void add(T novo)throws ElementoJaExisteException{
		if(!this.elementos.contains(novo))
		{
			elementos.add(novo);
		}
		else
		{
			throw new ElementoJaExisteException(novo);
		}
	}

	@Override
	public List<T> read() {
		return Collections.unmodifiableList(elementos);
	}

	@Override
	public void remove(T conteudo) throws ElementoNaoExisteException {
		if(this.elementos.contains(conteudo))
		{
			this.elementos.remove(this.elementos.indexOf(conteudo));
		}
		else
		{
			throw new ElementoNaoExisteException(conteudo);
		}
	}

	@Override
	public void update(T atual, T novoConteudo) throws ElementoNaoExisteException {
		if(this.elementos.contains(atual))
		{
			int indice = this.elementos.indexOf(atual);
			this.elementos.set(indice, novoConteudo);
		}
		else
		{
			throw new ElementoNaoExisteException(novoConteudo);
		}
	}
}
package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioGenerico<T> implements IRepositorioGenerico<T>{
	private List<T> qualquer;

	public RepositorioGenerico(List<T> qualquer) {
		super();
		this.qualquer = new ArrayList<>();
	}

	@Override
	public void add(T novo){
		if(!this.qualquer.contains(novo))
		{
			qualquer.add(novo);
		}
		else
		{
			throw new ElementoJaExisteException(novo);
		}
	}

	@Override
	public List<T> read() {
		return Collections.unmodifiableList(qualquer);
	}

	@Override
	public void remove(T conteudo) throws ElementoNaoExisteException {
		if(this.qualquer.contains(conteudo))
		{
			this.qualquer.remove(this.qualquer.indexOf(conteudo));
		}
		else
		{
			throw new ElementoNaoExisteException(conteudo);
		}
	}

	@Override
	public void update(T novoConteudo) throws ElementoNaoExisteException {
		if(this.qualquer.contains(novoConteudo))
		{
			int indice = this.qualquer.indexOf(novoConteudo);
			this.qualquer.set(indice, novoConteudo);
		}
		else
		{
			throw new ElementoNaoExisteException(novoConteudo);
		}
	}
}

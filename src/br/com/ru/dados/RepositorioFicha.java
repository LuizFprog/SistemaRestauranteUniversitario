package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;

public class RepositorioFicha<Ficha> implements IRepositorioGenerico<Ficha>{
	private List<Ficha> fichas;

	public RepositorioFicha(List<Ficha> fichas) {
		this.fichas = new ArrayList<>();
	}

	@Override
	public void add(Ficha novo)throws ElementoJaExisteException{
		if(!this.fichas.contains(novo))
		{
			fichas.add(novo);
		}
		else
		{
			throw new ElementoJaExisteException(novo);
		}
	}

	@Override
	public List<Ficha> read() {
		return Collections.unmodifiableList(fichas);
	}

	@Override
	public void remove(Ficha ficha) throws ElementoNaoExisteException {
		if(this.fichas.contains(ficha))
		{
			this.fichas.remove(this.fichas.indexOf(ficha));
		}
		else
		{
			throw new ElementoNaoExisteException(ficha);
		}
	}

	@Override
	public void update(Ficha atual, Ficha novoConteudo) throws ElementoNaoExisteException {
		if(this.fichas.contains(atual))
		{
			int indice = this.fichas.indexOf(atual);
			this.fichas.set(indice, novoConteudo);
		}
		else
		{
			throw new ElementoNaoExisteException(novoConteudo);
		}
	}
}
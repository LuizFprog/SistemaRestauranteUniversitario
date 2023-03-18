package br.com.ru.dados;

import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;

public interface IRepositorioGenerico<T> {
	
	public List<T> read();
	
	public void remove(T conteudo) throws ElementoNaoExisteException;
	
	public void update(T novoConteudo) throws ElementoNaoExisteException;

	public void add(T novo) throws ElementoJaExisteException;
}
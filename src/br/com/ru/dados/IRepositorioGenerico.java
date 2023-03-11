package br.com.ru.dados;

import java.util.List;

public interface IRepositorioGenerico<T> {
	
	//public List<T> add(T conteudo) throws ElementoJaExisteException;
	
	public List<T> read();
	
	public void remove(T conteudo); //throws ElementoNaoExisteException;
	
	public void update(T novoConteudo); //throws ElementoNaoExisteException;

	public void add(T novo); //throwsElementoJaExisteException;
}

package br.com.ru.dados;

import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;

public interface IRepositorioGenerico<T> {
	
	public List<T> ler();
	
	public void remover(T conteudo) throws ElementoNaoExisteException;
	
	public void atualizar(T atual, T novoConteudo) throws ElementoNaoExisteException;

	public void inserir(T atual) throws ElementoJaExisteException;
}
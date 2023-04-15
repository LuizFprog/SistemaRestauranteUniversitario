package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Refeicao;

public class RepositorioRefeicao  implements IRepositorioGenerico<Refeicao>{
	private List<Refeicao> refeicoes;
	
	
	public RepositorioRefeicao(List<Refeicao> refeicao)
	{
		this.refeicoes= new ArrayList<>();
		
	}
	
	@Override
	public void remover(Refeicao conteudo) throws ElementoNaoExisteException {
		
		if(this.refeicoes.contains(conteudo))
		{
			this.refeicoes.remove(this.refeicoes.indexOf(conteudo));
		}
		else
		{
			throw new ElementoNaoExisteException(conteudo);
		}
		
	}

	@Override
	public void atualizar(Refeicao atual, Refeicao novoConteudo) throws ElementoNaoExisteException {
		
		if(this.refeicoes.contains(atual))
		{
			int indice = this.refeicoes.indexOf(atual);
			this.refeicoes.set(indice, novoConteudo);
		}
		else
		{
			throw new ElementoNaoExisteException(novoConteudo);
		}
	}

	@Override
	public void inserir(Refeicao atual) throws ElementoJaExisteException {
		
		if(!this.refeicoes.contains(atual))
		{
			refeicoes.add(atual);
		}
		else
		{
			throw new ElementoJaExisteException(atual);
		}
	}
	
	@Override
	public List<Refeicao> ler() {
		return Collections.unmodifiableList(refeicoes);
	}
	
	 public List<Refeicao> lerTodos()
	    {
	    	return Collections.unmodifiableList(refeicoes);
	    }
}

package br.com.ru.negocio.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;

public class Refeicao implements IRepositorioGenerico<ItemConsumivel>{
	private List<ItemConsumivel> refeicao;
	
	
	public Refeicao(List<ItemConsumivel> refeicao)
	{
		this.refeicao = new ArrayList<>();
		
	}
	
	@Override
	public void inserir(ItemConsumivel novo)throws ElementoJaExisteException{
		if(!this.refeicao.contains(novo))
		{
			refeicao.add(novo);
		}
		else
		{
			throw new ElementoJaExisteException(novo);
		}
	}

	@Override
	public List<ItemConsumivel> ler() {
		return Collections.unmodifiableList(refeicao);
	}

	@Override
	public void remover(ItemConsumivel ficha) throws ElementoNaoExisteException {
		if(this.refeicao.contains(ficha))
		{
			this.refeicao.remove(this.refeicao.indexOf(ficha));
		}
		else
		{
			throw new ElementoNaoExisteException(ficha);
		}
	}

	@Override
	public void atualizar(ItemConsumivel atual, ItemConsumivel novoConteudo) throws ElementoNaoExisteException {
		if(this.refeicao.contains(atual))
		{
			int indice = this.refeicao.indexOf(atual);
			this.refeicao.set(indice, novoConteudo);
		}
		else
		{
			throw new ElementoNaoExisteException(novoConteudo);
		}
	}
}

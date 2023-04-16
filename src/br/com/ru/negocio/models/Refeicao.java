package br.com.ru.negocio.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;



public class Refeicao{
	
	private List<ItemConsumivel> itensConsumiveis;
	private Ficha fichas;
	//public Object getFicha;
	
	
	
	public Refeicao() {
		
	}
	
	public Refeicao(List<ItemConsumivel> itensConsumiveis, Ficha fichas) {
		super();
		this.itensConsumiveis = new ArrayList<>();
		this.fichas = fichas;
	}
	
	public List<ItemConsumivel> getItensConsumiveis() {
		return itensConsumiveis;
	}
	
	
	public void inserir(ItemConsumivel item) throws ElementoJaExisteException {
		
		if(!this.itensConsumiveis.contains(item))
		{
			itensConsumiveis.add(item);
		}
		else
		{
			throw new ElementoJaExisteException(item);
		}
	}
	
	public void remover(ItemConsumivel item) throws ElementoNaoExisteException {
		
		if(this.itensConsumiveis.contains(item))
		{
			this.itensConsumiveis.remove(this.itensConsumiveis.indexOf(item));
		}
		else
		{
			throw new ElementoNaoExisteException(item);
		}
		
	}

	public Ficha getFichas() {
		return fichas;
	}
	public void setFichas(Ficha fichas) {
		this.fichas = fichas;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(itensConsumiveis, fichas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refeicao other = (Refeicao) obj;
		return Objects.equals(itensConsumiveis, other.itensConsumiveis) && Objects.equals(fichas, other.fichas);
	}

	@Override
	public String toString() {
		return "Refeicao Cadastarda [ItensConsumiveis=" + itensConsumiveis + ", fichas=" + fichas + "]";
	}
	
}
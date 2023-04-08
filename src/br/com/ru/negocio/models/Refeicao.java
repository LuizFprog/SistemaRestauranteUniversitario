package br.com.ru.negocio.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class Refeicao{
	
	private List<ItemConsumivel> itensConsumiveis;
	private Ficha fichas;
	
	
	
	public Refeicao(List<ItemConsumivel> itensConsumiveis, Ficha fichas) {
		super();
		this.itensConsumiveis = new ArrayList<>();
		this.fichas = fichas;
	}
	
	public List<ItemConsumivel> getItensConsumiveis() {
		return itensConsumiveis;
	}
	public void setItensConsumiveis(List<ItemConsumivel> itens) {
		itensConsumiveis = itens;
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
		return "Refeicao [ItensConsumiveis=" + itensConsumiveis + ", fichas=" + fichas + "]";
	}
	
}
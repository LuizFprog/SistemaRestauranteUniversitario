package br.com.ru.negocio.models;

public class ItemConsumivel {
	
	public enum TipoCardapio
	{
		TRIVIAL, VEGANO, SUCO, SOBREMESA;
	}
	
	private String nome;
	private TipoCardapio tipoItemConsumivel;
	private boolean gluten;
	private boolean lactose;
	private boolean visivel;	
	
	public ItemConsumivel(String nome, boolean gluten, boolean lactose, 
			TipoCardapio tipoItemConsumivel, boolean visivel) {
		this.nome = nome;
		this.tipoItemConsumivel = tipoItemConsumivel;
		this.gluten = gluten;
		this.lactose = lactose;
		this.visivel = visivel;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}		
	
	public TipoCardapio getTipoItemConsumivel() {
		return tipoItemConsumivel;
	}

	public void setTipoItemConsumivel(TipoCardapio tipoItemConsumivel) {
		this.tipoItemConsumivel = tipoItemConsumivel;
	}

	public boolean isGluten() {
		return gluten;
	}
	
	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}
	
	public boolean isLactose() {
		return lactose;
	}
	
	public void setLactose(boolean lactose) {
		this.lactose = lactose;
	}
	
	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	@Override
	public String toString() {
		return "ItemConsumivel [nome=" + nome + ", tipoItemConsumivel=" + tipoItemConsumivel + ", gluten=" + gluten + ", lactose=" + lactose
				+ ", visivel=" + visivel + "]";
	}	
}

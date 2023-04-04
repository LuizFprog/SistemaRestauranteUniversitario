package br.com.ru.negocio.models;

public class ItemConsumivel {
	
	public enum TipoCardapio
	{
		TRIVIAL, VEGANO, SUCO, SOBREMESA;
	}
	
	private String nome;
	private TipoCardapio tipoPrato;
	private boolean gluten;
	private boolean lactose;
	private boolean visivel;	
	
	public ItemConsumivel(String nome, boolean gluten, boolean lactose, 
			TipoCardapio tipoPrato, boolean visivel) {
		this.nome = nome;
		this.tipoPrato = tipoPrato;
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
	
	public TipoCardapio getTipoPrato() {
		return tipoPrato;
	}

	public void setTipoPrato(TipoCardapio tipoPrato) {
		this.tipoPrato = tipoPrato;
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
		return "Prato [nome=" + nome + ", tipoPrato=" + tipoPrato + ", gluten=" + gluten + ", lactose=" + lactose
				+ ", visivel=" + visivel + "]";
	}
	
}

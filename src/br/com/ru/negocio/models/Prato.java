package br.com.ru.negocio.models;

public class Prato {
	
	private String nome;
	private boolean vegano;
	private boolean gluten;
	private boolean lactose;
	private boolean suco;
	
	
	
	public Prato(String nome, boolean vegano, boolean gluten, boolean lactose, boolean suco) {
		super(); 				// não sei oque faz.
		this.nome = nome;
		this.vegano = vegano;
		this.gluten = gluten;
		this.lactose = lactose;
		this.suco = suco;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isVegano() {
		return vegano;
	}
	
	public void setVegano(boolean vegano) {
		this.vegano = vegano;
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
	
	public boolean isSuco() {
		return suco;
	}
	
	public void setSuco(boolean suco) {
		this.suco = suco;
	}

	@Override
	public String toString() {
		return "Prato [nome=" + nome + ", vegano=" + vegano + ", gluten=" + gluten + ", lactose=" + lactose + ", suco="
				+ suco + "]";
	}
	
	
	
}

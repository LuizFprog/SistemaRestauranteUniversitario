package br.com.ru.negocio.models;

public class Ficha {
	
	private double precoAlmoco;
	private double precoJanta;
	private Cliente cliente;
	private String codigo;
	
	public Ficha(double pAlmoco, double pJanta, Cliente cliente, String cod) {
		
		this.precoAlmoco = pAlmoco;
		this.precoJanta = pJanta;
		this.cliente = cliente;
		this.codigo = cod;
		
		
	}
	
	public double getPrecoAlmoco() {
		return precoAlmoco;
	}
	
	public void setPrecoAlmoco(double precoAlmoco) {
		this.precoAlmoco = precoAlmoco;
	}
	
	public double getPrecoJanta() {
		return precoJanta;
	}
	
	public void setPrecoJanta(double precoJanta) {
		this.precoJanta = precoJanta;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Ficha [precoAlmoco=" + precoAlmoco + ", precoJanta=" + precoJanta + ", cliente=" + cliente + ", codigo="
				+ codigo + "]";
	}
	
	
	
	
}

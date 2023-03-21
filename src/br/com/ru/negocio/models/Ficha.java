package br.com.ru.negocio.models;

public class Ficha {
	
	private double preco;
	private Cliente cliente;
	private String codigo;
	
	public Ficha(double preco, Cliente cliente, String cod) {
		
		this.preco = 3.0;
		this.cliente = cliente;
		this.codigo = cod;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
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
		return "Ficha [Preço" + preco + ", cliente=" + cliente + ", codigo=" + codigo + "]";
	}
}

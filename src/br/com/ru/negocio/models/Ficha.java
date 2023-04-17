package br.com.ru.negocio.models;

import java.time.LocalDate;

public class Ficha {
	public enum StatusFicha
	{
		EFETIVADA, CONSUMIDA, NAO_OPERANTE;
	}
	
	private StatusFicha statusFicha;
	private static double preco =  3.0;
	private Cliente cliente;
	private String codigo;
	private LocalDate dataEfetivacao = null;
	private LocalDate dataConsumo = null;
	
	public Ficha(String cod) {
		
		this.codigo = cod;
		this.statusFicha = StatusFicha.NAO_OPERANTE;
	}
	
	public static double getPreco() {
		return preco;
	}
	
	public static void setPreco(double preco) {
		Ficha.preco = preco;
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

	public LocalDate getDataEfetivacao() {
		return dataEfetivacao;
	}

	public void setDataEfetivacao(LocalDate dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

	public LocalDate getDataConsumo() {
		return dataConsumo;
	}

	public void setDataConsumo(LocalDate dataConsumo) {
		this.dataConsumo = dataConsumo;
	}

	public StatusFicha getStatusFicha() {
		return statusFicha;
	}

	public void setStatusFicha(StatusFicha statusFicha) {
		this.statusFicha = statusFicha;
	}

	@Override
	public String toString() {
		return "Ficha [statusFicha=" + statusFicha + ", preco=" + preco + ", cliente=" + cliente + ", codigo=" + codigo
				+ ", dataEfetivacao=" + dataEfetivacao + ", dataConsumo=" + dataConsumo + "]";
	}
	
}

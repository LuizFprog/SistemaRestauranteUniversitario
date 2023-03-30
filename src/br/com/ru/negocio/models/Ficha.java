package br.com.ru.negocio.models;

import java.time.LocalDateTime;

public class Ficha {
	public enum StatusFicha
	{
		EFETIVADA, CONSUMIDA, NAO_OPERANTE;
	}
	
	private StatusFicha statusFicha;
	private static double preco;
	private Cliente cliente;
	private String codigo;
	private LocalDateTime dataEfetivacao = null;
	private LocalDateTime dataConsumo = null;
	private Refeicao refeicao = null;
	
	public Ficha(String cod) {
		
		Ficha.preco = 3.0;
		this.cliente = null;
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

	public LocalDateTime getDataEfetivacao() {
		return dataEfetivacao;
	}

	public void setDataEfetivacao(LocalDateTime dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

	public LocalDateTime getDataConsumo() {
		return dataConsumo;
	}

	public void setDataConsumo(LocalDateTime dataConsumo) {
		this.dataConsumo = dataConsumo;
	}

	public StatusFicha getStatusFicha() {
		return statusFicha;
	}

	public void setStatusFicha(StatusFicha statusFicha) {
		this.statusFicha = statusFicha;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	@Override
	public String toString() {
		return "Ficha [statusFicha=" + statusFicha + ", preco=" + preco + ", cliente=" + cliente + ", codigo=" + codigo
				+ ", dataEfetivacao=" + dataEfetivacao + ", dataConsumo=" + dataConsumo + "]";
	}

	


	
}

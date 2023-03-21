package br.com.ru.negocio.models;

public class Cliente extends Usuario{
	
	
	private int numeroFichas;
	private double saldo;
	
	public Cliente(String primeiroNome, String ultimoNome, String cpf, String login, String senha) {
		super(primeiroNome, ultimoNome, cpf, login, senha);
		
	}
	
	
	public int getNumeroFichas() {
		return numeroFichas;
	}


	public void aumentarNumeroFichas() {
		this.numeroFichas++;
	}
	
	public void diminuirNumeroFichas() {
		this.numeroFichas++;
	}


	public void depositar(double valor) {
		if(valor >= 0)
		{
			this.saldo = this.saldo + valor;
		}
	}
	
	public void debitar (double valor)
	{
		if(valor >= 0)
		{
			this.saldo = this.saldo - valor;
		}
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	@Override
	public String toString() {
		return "Cliente [numeroFichas=" + numeroFichas + ", saldo=" + saldo + "] " + super.toString();
	}
}

package br.com.ru.negocio.models;

public class Cliente extends Usuario{
	
	private double saldo;
	
	public Cliente(String primeiroNome, String ultimoNome, String cpf, String login, String senha, double saldo) {
		super(primeiroNome, ultimoNome, cpf, login, senha);
		this.saldo = saldo;
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
		return super.toString() + "Cliente [saldo = " + saldo + "] ";
	}
}

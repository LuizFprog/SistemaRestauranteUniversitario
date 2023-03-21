package br.com.ru.exceptions;

public class SaldoInsuficienteException extends Exception{
    
	private static final long serialVersionUID = 1L;
	public double saldo;

    public SaldoInsuficienteException(double saldo) {
        super("O Saldo é insuficiente para a compra!");
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

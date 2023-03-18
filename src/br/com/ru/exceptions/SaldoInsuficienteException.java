package br.com.ru.exceptions;

public class SaldoInsuficienteException extends Exception{
    
	private static final long serialVersionUID = 1L;
	public int saldo;

    public SaldoInsuficienteException(int saldo) {
        super("O Saldo é insuficiente para a compra!");
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}

package br.com.ru.exceptions;

public class ElementoJaExisteException extends Exception{

	private Object elemento;
	
	public ElementoJaExisteException(Object elemento)
	{
		super("Já existe");
		this.elemento = elemento;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	
	
}

package br.com.ru.exceptions;

public class ElementoJaExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	private Object elemento;

	public ElementoJaExisteException(Object obj) {
		super("O Objeto mencionado já existe no repositório!");
		this.elemento = obj;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
}

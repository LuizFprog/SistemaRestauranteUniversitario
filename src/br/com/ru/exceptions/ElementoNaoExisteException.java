package br.com.ru.exceptions;

public class ElementoNaoExisteException extends Exception{
    private Object elemento;

    public ElementoNaoExisteException(Object obj) {
        super("O Objeto mencionado não existe no repositório!");
        this.elemento = obj;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
}

package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Cliente;

public class RepositorioCliente implements IRepositorioGenerico<Cliente>{
	private List<Cliente> clientes;

	public RepositorioCliente(List<Cliente> clientes) {
		this.clientes = new ArrayList<>();
	}

	@Override
	public void inserir(Cliente novo)throws ElementoJaExisteException{
		if(!this.clientes.contains(novo))
		{
			clientes.add(novo);
		}
		else
		{
			throw new ElementoJaExisteException(novo);
		}
	}

	@Override
	public List<Cliente> ler() {
		return Collections.unmodifiableList(clientes);
	}

	@Override
	public void remover(Cliente cliente) throws ElementoNaoExisteException {
		if(this.clientes.contains(cliente))
		{
			this.clientes.remove(this.clientes.indexOf(cliente));
		}
		else
		{
			throw new ElementoNaoExisteException(cliente);
		}
	}

	@Override
	public void atualizar(Cliente atual, Cliente novoConteudo) throws ElementoNaoExisteException {
		if(this.clientes.contains(novoConteudo))
		{
			int indice = this.clientes.indexOf(novoConteudo);
			this.clientes.set(indice, novoConteudo);
		}
		else
		{
			throw new ElementoNaoExisteException(novoConteudo);
		}
	}
}
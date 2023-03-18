package br.com.ru.negocio;

import java.util.List;

import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioGenerico;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Prato;

public class ControladorPrato {
	private IRepositorioGenerico<Prato> repositorioPrato;
	private static ControladorPrato instancia;
	private List<Prato> listaPrato;
	
	public ControladorPrato() {
		this.repositorioPrato = new RepositorioGenerico<Prato>(listaPrato);
	}
	
	public static ControladorPrato getInstance()
	{
		if(instancia == null)
		{
			instancia = new ControladorPrato();
		}
		return instancia;
	}
	
	public void adicionarPrato (String nome, boolean vegano, boolean gluten, 
			boolean lactose, boolean suco, boolean visivel) 
			throws ElementoJaExisteException
	{
		if(nome != null)
		{
			Prato novoPrato = new Prato(nome, vegano, gluten, lactose, suco, visivel);
			repositorioPrato.add(novoPrato);
		}
	}
	
	public List<Prato> listarPratos()
	{
		return repositorioPrato.read();
	}
	
	public void removerPrato (Prato pratoRemover) 
			throws ElementoNaoExisteException
	{
		repositorioPrato.remove(pratoRemover);
	}
	
	public void atualizarPrato (Prato prato, String nome, boolean vegano, 
			boolean gluten, boolean lactose, boolean suco, boolean visivel) 
					throws ElementoNaoExisteException
	{
		if(nome != null)
		{
			Prato novoPrato = new Prato(nome, vegano, gluten, lactose, suco, visivel);
			repositorioPrato.update(prato, novoPrato);
		}
	}
}

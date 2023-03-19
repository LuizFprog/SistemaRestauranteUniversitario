package br.com.ru.negocio;

import java.util.List;


import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioPrato;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Prato;

public class ControladorPrato {
	private IRepositorioGenerico<Prato> cardapio;
	private static ControladorPrato instancia;
	private List<Prato> listaPrato;
	
	public ControladorPrato() {
		this.cardapio = new RepositorioPrato(listaPrato);
	}
	
	
	// Garantir unica instancia da classe
	public static ControladorPrato getInstancia()
	{
		if(instancia == null)
		{
			instancia = new ControladorPrato();
		}
		return instancia;
	}
	
	
	// Metodo para adicionar pratos
	public void adicionarPrato (String nome, boolean vegano, boolean gluten, 
			boolean lactose, boolean suco, boolean visivel) 
			throws ElementoJaExisteException
	{
		if(nome != null)
		{
			Prato novoPrato = new Prato(nome, vegano, gluten, lactose, suco, visivel);
			cardapio.inserir(novoPrato);
		}
	}
	
	// Metodo para Mostrar Cardapio
	public List<Prato> mostrarCardapio()
	{
		return cardapio.ler();
	}
	
	// Metodo para remover prato
	public void removerPrato (Prato pratoRemover) 
			throws ElementoNaoExisteException
	{
		if(pratoRemover != null)
		{
			cardapio.remover(pratoRemover);
		}
	}
	
	// Metodo para atualizar prato
	public void atualizarPrato (Prato prato, String nome, boolean vegano, 
			boolean gluten, boolean lactose, boolean suco, boolean visivel) 
					throws ElementoNaoExisteException
	{
		if(nome != null)
		{
			Prato novoPrato = new Prato(nome, vegano, gluten, lactose, suco, visivel);
			if(!prato.equals(novoPrato) && novoPrato != null)
			{
				cardapio.atualizar(prato, novoPrato);
			}
		}
	}
}

package br.com.ru.negocio;

import java.util.List;


import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioPrato;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.ItemConsumivel;
import br.com.ru.negocio.models.ItemConsumivel.TipoCardapio;

public class ControladorPrato {
	private IRepositorioGenerico<ItemConsumivel> cardapio;
	private static ControladorPrato instancia;
	private List<ItemConsumivel> listaPrato;
	
	private ControladorPrato() {
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
	public void adicionarPrato (String nome, boolean gluten, 
			boolean lactose, TipoCardapio tipoPrato, boolean visivel) 
			throws ElementoJaExisteException
	{
		if(nome != null)
		{
			ItemConsumivel novoPrato = new ItemConsumivel(nome, gluten, lactose, tipoPrato, visivel);
			cardapio.inserir(novoPrato);
		}
	}
	
	// Metodo para Mostrar Cardapio
	public List<ItemConsumivel> mostrarCardapio()
	{
		return cardapio.ler();
	}
	
	public List<ItemConsumivel> listarTodosPratos()
	{
		return ((RepositorioPrato) cardapio).lerTodos();
	}
	
	// Metodo para remover prato
	public void removerPrato (String nome) 
			throws ElementoNaoExisteException
	{
		ItemConsumivel pratoAtual = recuperarPrato(nome);
		
		if(pratoAtual != null)
		{
			cardapio.remover(pratoAtual);
		}
	}
	
	public ItemConsumivel recuperarPrato(String nome) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		List<ItemConsumivel> pratos = ((RepositorioPrato) cardapio).lerTodos();
		for (ItemConsumivel p : pratos) {
			if (p.getNome().equals(nome)) {
				return p;
			}
		}
		// Caso não encontre, lança exceção
		throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
	}
	
	// Metodo para atualizar prato
	public void atualizarPrato (String nomeAtual, String nome, boolean gluten, boolean lactose, TipoCardapio tipoPrato, 
			boolean visivel) 
					throws ElementoNaoExisteException
	{
		
		ItemConsumivel pratoAtual = recuperarPrato(nomeAtual);
		
		if(pratoAtual != null)
		{
			ItemConsumivel novoPrato = new ItemConsumivel(nome, gluten, lactose, tipoPrato, visivel);
			if(!pratoAtual.equals(novoPrato) && novoPrato != null)
			{
				cardapio.atualizar(pratoAtual, novoPrato);
			}
		}
	}
	
	// Metodo para colocar prato como visivel
	public void pratoVisivel(ItemConsumivel prato) throws ElementoNaoExisteException
	{
		prato.setVisivel(true);
	}
	
	public void pratoNaoVisivel(ItemConsumivel prato) throws ElementoNaoExisteException
	{
		prato.setVisivel(false);
	}
}

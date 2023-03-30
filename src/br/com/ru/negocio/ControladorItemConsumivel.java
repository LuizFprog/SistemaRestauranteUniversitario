package br.com.ru.negocio;

import java.util.ArrayList;
import java.util.List;


import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioItemConsumivel;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.ItemConsumivel;
import br.com.ru.negocio.models.ItemConsumivel.TipoCardapio;

public class ControladorItemConsumivel {
	private IRepositorioGenerico<ItemConsumivel> cardapio;
	private static ControladorItemConsumivel instancia;
	private List<ItemConsumivel> listaPrato;
	
	private ControladorItemConsumivel() {
		this.cardapio = new RepositorioItemConsumivel(listaPrato);
	}
	
	
	// Garantir unica instancia da classe
	public static ControladorItemConsumivel getInstancia()
	{
		if(instancia == null)
		{
			instancia = new ControladorItemConsumivel();
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
	
	public List<ItemConsumivel> cardapioTrivial()
	{
		List<ItemConsumivel> atual = ((RepositorioItemConsumivel) cardapio).lerTodos();
		List<ItemConsumivel> trivial = new ArrayList<>();
		for(ItemConsumivel i : atual)
		{
			if(i.getTipoPrato() == TipoCardapio.TRIVIAL)
			{
				trivial.add(i);
			}
		}
		return trivial;
	}
	
	public List<ItemConsumivel> cardapioVegano()
	{
		List<ItemConsumivel> atual = ((RepositorioItemConsumivel) cardapio).lerTodos();
		List<ItemConsumivel> vegano = new ArrayList<>();
		for(ItemConsumivel i : atual)
		{
			if(i.getTipoPrato() == TipoCardapio.VEGANO)
			{
				vegano.add(i);
			}
		}
		return vegano;
	}
	
	public List<ItemConsumivel> cardapioSuco()
	{
		List<ItemConsumivel> atual = ((RepositorioItemConsumivel) cardapio).lerTodos();
		List<ItemConsumivel> suco = new ArrayList<>();
		for(ItemConsumivel i : atual)
		{
			if(i.getTipoPrato() == TipoCardapio.SUCO)
			{
				suco.add(i);
			}
		}
		return suco;
	}
	
	public List<ItemConsumivel> cardapioSobremesa()
	{
		List<ItemConsumivel> atual = ((RepositorioItemConsumivel) cardapio).lerTodos();
		List<ItemConsumivel> sobremesa = new ArrayList<>();
		for(ItemConsumivel i : atual)
		{
			if(i.getTipoPrato() == TipoCardapio.SOBREMESA)
			{
				sobremesa.add(i);
			}
		}
		return sobremesa;
	}
	
	public List<ItemConsumivel> listarTodosPratos()
	{
		return ((RepositorioItemConsumivel) cardapio).lerTodos();
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
		List<ItemConsumivel> pratos = ((RepositorioItemConsumivel) cardapio).lerTodos();
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

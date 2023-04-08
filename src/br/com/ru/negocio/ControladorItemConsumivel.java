package br.com.ru.negocio;

import java.util.ArrayList;
import java.util.List;


import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioItemConsumivel;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.ItemConsumivel;
import br.com.ru.negocio.models.ItemConsumivel.TipoCardapio;
import br.com.ru.negocio.models.Refeicao;

public class ControladorItemConsumivel {
	private IRepositorioGenerico<ItemConsumivel> cardapio;
	private IRepositorioGenerico<ItemConsumivel> refeicao;
	private static ControladorItemConsumivel instancia;
	private List<ItemConsumivel> listaItemConsumivel;
	
	private ControladorItemConsumivel() {
		this.cardapio = new RepositorioItemConsumivel(listaItemConsumivel);
		this.refeicao = new Refeicao(listaItemConsumivel);
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
	public void adicionarItemConsumivel (String nome, boolean gluten, 
			boolean lactose, TipoCardapio tipoPrato, boolean visivel) 
			throws ElementoJaExisteException
	{
		if(nome != null)
		{
			ItemConsumivel novoItemConsumivel = new ItemConsumivel(nome, gluten, lactose, tipoPrato, visivel);
			cardapio.inserir(novoItemConsumivel);
		}
	}
	
	public void adicionarItemConsumivelNaRefeicao(String itemConsumivel) throws ElementoJaExisteException, ElementoNaoExisteException
	{
		ItemConsumivel novoItemConsumivel = recuperarItemConsumivel(itemConsumivel);
		if(itemConsumivel != null && novoItemConsumivel != null && novoItemConsumivel.isVisivel())
		{
			this.refeicao.inserir(novoItemConsumivel);
		}
	}
	
	public void removerItemConsumivelDaRefeicao(String itemConsumivel) throws ElementoNaoExisteException
	{
		ItemConsumivel itemConsumivelRemover = recuperarItemConsumivel(itemConsumivel);
		List<ItemConsumivel> pratos = refeicao.ler();
		if(pratos.contains(itemConsumivelRemover))
		{
			refeicao.remover(itemConsumivelRemover);
		}
	}
	
	public List<ItemConsumivel> listarRefeicao()
	{
		return refeicao.ler();
	}
	
	public void resetarRefeicao()
	{
		refeicao = null;
	}
	
	// Metodo para Mostrar Cardapio
	public List<ItemConsumivel> mostrarCardapio()
	{
		return cardapio.ler(); // Modificação necessaria
	}
	
	private List<ItemConsumivel> tipoCardapio (TipoCardapio tipo)
	{
		List<ItemConsumivel> atual = ((RepositorioItemConsumivel) cardapio).ler(); // Modificação necessaria
		List<ItemConsumivel> cardapioDoTipoEspecificado = new ArrayList<>();
		for(ItemConsumivel i : atual)
		{
			if(i.getTipoItemConsumivel() == tipo)
			{
				cardapioDoTipoEspecificado.add(i);
			}
		}
		return cardapioDoTipoEspecificado;
	}
	
	public List<ItemConsumivel> cardapioTrivial()
	{
		return tipoCardapio(TipoCardapio.TRIVIAL);
	}
	
	public List<ItemConsumivel> cardapioVegano()
	{
		return tipoCardapio(TipoCardapio.VEGANO);
	}
	
	public List<ItemConsumivel> cardapioSuco()
	{
		return tipoCardapio(TipoCardapio.SUCO);
	}
	
	public List<ItemConsumivel> cardapioSobremesa()
	{
		return tipoCardapio(TipoCardapio.SOBREMESA);
	}
	
	public List<ItemConsumivel> listarTodosItemConsumiveis()
	{
		return ((RepositorioItemConsumivel) cardapio).lerTodos();
	}
	
	// Metodo para remover prato
	public void removerItemConsumivel (String nome) 
			throws ElementoNaoExisteException
	{
		ItemConsumivel itemConsumivelAtual = recuperarItemConsumivel(nome);
		
		if(itemConsumivelAtual != null)
		{
			cardapio.remover(itemConsumivelAtual);
		}
	}
	
	public ItemConsumivel recuperarItemConsumivel(String nome) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		List<ItemConsumivel> itemConsumivel = ((RepositorioItemConsumivel) cardapio).lerTodos();
		for (ItemConsumivel p : itemConsumivel) {
			if (p.getNome().equals(nome)) {
				return p;
			}
		}
		// Caso não encontre, lança exceção
		throw new ElementoNaoExisteException("Não existe esse prato no sistema");
	}
	
	// Metodo para atualizar prato
	public void atualizarItemConsumivel (String nomeAtual, String nome, boolean gluten, boolean lactose, TipoCardapio tipoPrato, 
			boolean visivel) 
					throws ElementoNaoExisteException
	{
		
		ItemConsumivel itemConsumivelAtual = recuperarItemConsumivel(nomeAtual);
		
		if(itemConsumivelAtual != null)
		{
			ItemConsumivel novoItemConsumivel = new ItemConsumivel(nome, gluten, lactose, tipoPrato, visivel);
			if(!itemConsumivelAtual.equals(novoItemConsumivel) && novoItemConsumivel != null)
			{
				cardapio.atualizar(itemConsumivelAtual, novoItemConsumivel);
			}
		}
	}
	
	// Metodo para colocar prato como visivel
	public void itemConsumivelVisivel(ItemConsumivel itemConsumivel) throws ElementoNaoExisteException
	{
		itemConsumivel.setVisivel(true);
	}
	
	public void itemConsumivelNaoVisivel(ItemConsumivel itemConsumivel) throws ElementoNaoExisteException
	{
		itemConsumivel.setVisivel(false);
	}
}

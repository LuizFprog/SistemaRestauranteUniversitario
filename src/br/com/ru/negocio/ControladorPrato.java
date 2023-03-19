package br.com.ru.negocio;

import java.util.List;


import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioPrato;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Cliente;
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
			boolean lactose, boolean suco, boolean sobremesa, boolean visivel) 
			throws ElementoJaExisteException
	{
		if(nome != null)
		{
			Prato novoPrato = new Prato(nome, vegano, gluten, lactose, suco, sobremesa, visivel);
			cardapio.inserir(novoPrato);
		}
	}
	
	// Metodo para Mostrar Cardapio
	public List<Prato> mostrarCardapio()
	{
		return cardapio.ler();
	}
	
	// Metodo para remover prato
	public void removerPrato (String nome) 
			throws ElementoNaoExisteException
	{
		Prato pratoAtual = recuperarPrato(nome);
		
		if(pratoAtual != null)
		{
			cardapio.remover(pratoAtual);
		}
	}
	
	public Prato recuperarPrato(String nome) throws ElementoNaoExisteException {
		// Busca o cliente pelo CPF
		List<Prato> pratos = cardapio.ler();
		for (Prato p : pratos) {
			if (p.getNome().equals(nome)) {
				return p;
			}
		}
		// Caso não encontre, lança exceção
		throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
	}
	
	// Metodo para atualizar prato
	public void atualizarPrato (String nomeAtual, String nome, boolean vegano, 
			boolean gluten, boolean lactose, boolean suco, boolean sobremesa, boolean visivel) 
					throws ElementoNaoExisteException
	{
		
		Prato pratoAtual = recuperarPrato(nomeAtual);
		
		if(pratoAtual != null)
		{
			Prato novoPrato = new Prato(nome, vegano, gluten, lactose, suco, sobremesa, visivel);
			if(!pratoAtual.equals(novoPrato) && novoPrato != null)
			{
				cardapio.atualizar(pratoAtual, novoPrato);
			}
		}
	}
}

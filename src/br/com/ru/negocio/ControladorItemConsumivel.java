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
	private List<ItemConsumivel> listaItemConsumivel;

	private ControladorItemConsumivel() {
		this.cardapio = new RepositorioItemConsumivel(listaItemConsumivel);
	}

	// Garantir unica instancia da classe
	public static ControladorItemConsumivel getInstancia() {
		if (instancia == null) {
			instancia = new ControladorItemConsumivel();
		}
		return instancia;
	}

	// Metodo para adicionar ItemConsumivel
	public void adicionarItemConsumivel(String nome, boolean gluten, boolean lactose, TipoCardapio tipoPrato,
			boolean visivel) throws ElementoJaExisteException {
		if (nome != null) {
			ItemConsumivel novoItemConsumivel = new ItemConsumivel(nome, gluten, lactose, tipoPrato, visivel);
			cardapio.inserir(novoItemConsumivel);
		}
	}

	// Metodo para Mostrar Cardapio
	public List<ItemConsumivel> mostrarCardapio() {
		return cardapio.ler(); 
	}

	private List<ItemConsumivel> tipoCardapio(TipoCardapio tipo) {
		List<ItemConsumivel> atual = ((RepositorioItemConsumivel) cardapio).ler(); 
		List<ItemConsumivel> cardapioDoTipoEspecificado = new ArrayList<>();
		for (ItemConsumivel i : atual) {
			if (i.getTipoItemConsumivel() == tipo) {
				cardapioDoTipoEspecificado.add(i);
			}
		}
		return cardapioDoTipoEspecificado;
	}

	public List<ItemConsumivel> cardapioTrivial() {
		return tipoCardapio(TipoCardapio.TRIVIAL);
	}

	public String listaCardapioTrivial() {
		return cardapioTrivial().toString();
	}

	public List<ItemConsumivel> cardapioVegano() {
		return tipoCardapio(TipoCardapio.VEGANO);
	}

	public List<ItemConsumivel> cardapioSuco() {
		return tipoCardapio(TipoCardapio.SUCO);
	}

	public List<ItemConsumivel> cardapioSobremesa() {
		return tipoCardapio(TipoCardapio.SOBREMESA);
	}

	public List<ItemConsumivel> listarTodosItemConsumiveis() {
		return ((RepositorioItemConsumivel) cardapio).lerTodos();
	}

	// Metodo para remover ItemConsumivel
	public void removerItemConsumivel(String nome) throws ElementoNaoExisteException {
		ItemConsumivel itemConsumivelAtual = recuperarItemConsumivel(nome);

		if (itemConsumivelAtual != null) {
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
		throw new ElementoNaoExisteException("Não existe o Item consumivel no sistema");
	}

	// Metodo para atualizar prato
	public void atualizarItemConsumivel(String nomeAtual, String nome, boolean gluten, boolean lactose,
			TipoCardapio tipoPrato, boolean visivel) throws ElementoNaoExisteException {

		ItemConsumivel itemConsumivelAtual = recuperarItemConsumivel(nomeAtual);

		if (itemConsumivelAtual != null) {
			ItemConsumivel novoItemConsumivel = new ItemConsumivel(nome, gluten, lactose, tipoPrato, visivel);
			if (!itemConsumivelAtual.equals(novoItemConsumivel) && novoItemConsumivel != null) {
				cardapio.atualizar(itemConsumivelAtual, novoItemConsumivel);
			}
		}
	}

	// Metodo para colocar ItemConsumivel como visivel
	public void itemConsumivelVisivel(ItemConsumivel itemConsumivel) throws ElementoNaoExisteException {
		itemConsumivel.setVisivel(true);
	}

	public void itemConsumivelNaoVisivel(ItemConsumivel itemConsumivel) throws ElementoNaoExisteException {
		itemConsumivel.setVisivel(false);
	}
}

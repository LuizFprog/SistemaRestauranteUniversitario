package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.ItemConsumivel;

public class RepositorioItemConsumivel implements IRepositorioGenerico<ItemConsumivel> {
	private List<ItemConsumivel> itensConsumiveis;

	public RepositorioItemConsumivel(List<ItemConsumivel> itensConsumiveis) {
		this.itensConsumiveis = new ArrayList<>();
	}

	@Override
	public void inserir(ItemConsumivel novoItemConsumivel) throws ElementoJaExisteException {
		if (!this.itensConsumiveis.contains(novoItemConsumivel)) {
			itensConsumiveis.add(novoItemConsumivel);
		} else {
			throw new ElementoJaExisteException(novoItemConsumivel);
		}
	}

	@Override
	public List<ItemConsumivel> ler() {
		return listarVisiveis();
	}

	public List<ItemConsumivel> lerTodos() {
		return Collections.unmodifiableList(itensConsumiveis);
	}

	public List<ItemConsumivel> listarVisiveis() {
		List<ItemConsumivel> visiveis = new ArrayList<>();
		for (ItemConsumivel itemConsumivel : itensConsumiveis) {
			if (itemConsumivel.isVisivel()) {
				visiveis.add(itemConsumivel);
			}
		}
		return Collections.unmodifiableList(visiveis);
	}

	@Override
	public void remover(ItemConsumivel conteudo) throws ElementoNaoExisteException {
		if (this.itensConsumiveis.contains(conteudo)) {
			this.itensConsumiveis.remove(conteudo);
		} else {
			throw new ElementoNaoExisteException(conteudo);
		}
	}

	@Override
	public void atualizar(ItemConsumivel itemConsumivel, ItemConsumivel novoItemConsumivel)
			throws ElementoNaoExisteException {
		if (this.itensConsumiveis.contains(itemConsumivel)) {
			int indice = this.itensConsumiveis.indexOf(itemConsumivel);
			this.itensConsumiveis.set(indice, novoItemConsumivel);
		} else {
			throw new ElementoNaoExisteException(itemConsumivel);
		}
	}
}
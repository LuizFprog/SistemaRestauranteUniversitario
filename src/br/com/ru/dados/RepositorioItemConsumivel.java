package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.ItemConsumivel;

public class RepositorioItemConsumivel implements IRepositorioGenerico<ItemConsumivel> {
    private List<ItemConsumivel> itemConsumivels;

    public RepositorioItemConsumivel(List<ItemConsumivel> itemConsumivels) {
        this.itemConsumivels = new ArrayList<>();
    }

    @Override
    public void inserir(ItemConsumivel novoItemConsumivel) throws ElementoJaExisteException {
        if (!this.itemConsumivels.contains(novoItemConsumivel)) {
            itemConsumivels.add(novoItemConsumivel);
        } else {
            throw new ElementoJaExisteException(novoItemConsumivel);
        }
    }

    @Override
    public List<ItemConsumivel> ler() {
        return listarVisiveis();
    }
    
    public List<ItemConsumivel> lerTodos()
    {
    	return Collections.unmodifiableList(itemConsumivels);
    }

    public List<ItemConsumivel> listarVisiveis() {
        List<ItemConsumivel> visiveis = new ArrayList<>();
        for (ItemConsumivel itemConsumivel : itemConsumivels) {
            if (itemConsumivel.isVisivel()) {
                visiveis.add(itemConsumivel);
            }
        }
        return Collections.unmodifiableList(visiveis);
    }

    @Override
    public void remover(ItemConsumivel conteudo) throws ElementoNaoExisteException {
        if (this.itemConsumivels.contains(conteudo)) {
            this.itemConsumivels.remove(conteudo);
        } else {
            throw new ElementoNaoExisteException(conteudo);
        }
    }

    @Override
    public void atualizar(ItemConsumivel itemConsumivel, ItemConsumivel novoItemConsumivel) throws ElementoNaoExisteException {
        if (this.itemConsumivels.contains(itemConsumivel)) {
            int indice = this.itemConsumivels.indexOf(itemConsumivel);
            this.itemConsumivels.set(indice, novoItemConsumivel);
        } else {
            throw new ElementoNaoExisteException(itemConsumivel);
        }
    }
}
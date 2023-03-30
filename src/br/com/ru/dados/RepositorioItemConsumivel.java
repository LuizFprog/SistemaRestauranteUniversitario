package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.ItemConsumivel;

public class RepositorioItemConsumivel implements IRepositorioGenerico<ItemConsumivel> {
    private List<ItemConsumivel> pratos;

    public RepositorioItemConsumivel(List<ItemConsumivel> pratos) {
        this.pratos = new ArrayList<>();
    }

    @Override
    public void inserir(ItemConsumivel novoPrato) throws ElementoJaExisteException {
        if (!this.pratos.contains(novoPrato)) {
            pratos.add(novoPrato);
        } else {
            throw new ElementoJaExisteException(novoPrato);
        }
    }

    @Override
    public List<ItemConsumivel> ler() {
        return listarVisiveis();
    }
    
    public List<ItemConsumivel> lerTodos()
    {
    	return Collections.unmodifiableList(pratos);
    }

    public List<ItemConsumivel> listarVisiveis() {
        List<ItemConsumivel> visiveis = new ArrayList<>();
        for (ItemConsumivel prato : pratos) {
            if (prato.isVisivel()) {
                visiveis.add(prato);
            }
        }
        return Collections.unmodifiableList(visiveis);
    }

    @Override
    public void remover(ItemConsumivel conteudo) throws ElementoNaoExisteException {
        if (this.pratos.contains(conteudo)) {
            this.pratos.remove(conteudo);
        } else {
            throw new ElementoNaoExisteException(conteudo);
        }
    }

    @Override
    public void atualizar(ItemConsumivel prato, ItemConsumivel novoPrato) throws ElementoNaoExisteException {
        if (this.pratos.contains(prato)) {
            int indice = this.pratos.indexOf(prato);
            this.pratos.set(indice, novoPrato);
        } else {
            throw new ElementoNaoExisteException(prato);
        }
    }
}
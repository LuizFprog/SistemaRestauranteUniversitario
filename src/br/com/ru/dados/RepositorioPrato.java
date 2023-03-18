package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Prato;

public class RepositorioPrato implements IRepositorioGenerico<Prato> {
    private List<Prato> pratos;

    public RepositorioPrato(List<Prato> pratos) {
        this.pratos = pratos;
    }

    @Override
    public void add(Prato novoPrato) throws ElementoJaExisteException {
        if (!this.pratos.contains(novoPrato)) {
            pratos.add(novoPrato);
        } else {
            throw new ElementoJaExisteException(novoPrato);
        }
    }

    @Override
    public List<Prato> read() {
        return listarVisiveis();
    }

    public List<Prato> listarVisiveis() {
        List<Prato> visiveis = new ArrayList<>();
        for (Prato prato : pratos) {
            if (prato.isVisivel()) {
                visiveis.add(prato);
            }
        }
        return Collections.unmodifiableList(visiveis);
    }

    @Override
    public void remove(Prato conteudo) throws ElementoNaoExisteException {
        if (this.pratos.contains(conteudo)) {
            this.pratos.remove(conteudo);
        } else {
            throw new ElementoNaoExisteException(conteudo);
        }
    }

    @Override
    public void update(Prato prato, Prato novoPrato) throws ElementoNaoExisteException {
        if (this.pratos.contains(prato)) {
            int indice = this.pratos.indexOf(prato);
            this.pratos.set(indice, novoPrato);
        } else {
            throw new ElementoNaoExisteException(prato);
        }
    }
}
package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Funcionario;

public class RepositorioFuncionario implements IRepositorioGenerico<Funcionario>{
	private List<Funcionario> funcionarios;

	public RepositorioFuncionario(List<Funcionario> funcionarios) {
		super();
		this.funcionarios = new ArrayList<>();
	}

	@Override
	public void inserir(Funcionario novo)throws ElementoJaExisteException{
		if(!this.funcionarios.contains(novo))
		{
			funcionarios.add(novo);
		}
		else
		{
			throw new ElementoJaExisteException(novo);
		}
	}

	@Override
	public List<Funcionario> ler() {
		return Collections.unmodifiableList(funcionarios);
	}

	@Override
	public void remover(Funcionario funcionario) throws ElementoNaoExisteException {
		if(this.funcionarios.contains(funcionario))
		{
			this.funcionarios.remove(this.funcionarios.indexOf(funcionario));
		}
		else
		{
			throw new ElementoNaoExisteException(funcionario);
		}
	}

	@Override
	public void atualizar(Funcionario atual, Funcionario novoConteudo) throws ElementoNaoExisteException {
		if(this.funcionarios.contains(atual))
		{
			int indice = this.funcionarios.indexOf(atual);
			this.funcionarios.set(indice, novoConteudo);
		}
		else
		{
			throw new ElementoNaoExisteException(novoConteudo);
		}
	}
}

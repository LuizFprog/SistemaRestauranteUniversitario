package br.com.ru.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.models.Ficha;

public class RepositorioFicha implements IRepositorioGenerico<Ficha>{
	private List<Ficha> fichas;

	public RepositorioFicha(List<Ficha> fichas) 
	{
		this.fichas = new ArrayList<>();
	}

	@Override
	public void inserir(Ficha novo)throws ElementoJaExisteException
	{
		if(!this.fichas.contains(novo))
		{
			fichas.add(novo);
		}
		else
		{
			throw new ElementoJaExisteException(novo);
		}
	}

	@Override
	public List<Ficha> ler() 
	{
		return Collections.unmodifiableList(fichas);
	}
	
	public List<Ficha> lerMes(int mes)
	{
		List<Ficha> fichaMes = new ArrayList<>();
		for(Ficha f : fichas)
		{
			if(f.getDataConsumo().getMonthValue() == mes)
			{
				fichaMes.add(f);
			}
		}
		return fichaMes;
	}
	
	public List<Ficha> lerDia(int dia)
	{
		List<Ficha> fichaMes = new ArrayList<>();
		for(Ficha f : fichas)
		{
			if(f.getDataConsumo().getDayOfMonth() == dia)
			{
				fichaMes.add(f);
			}
		}
		return fichaMes;
	}
	
	public List<Ficha> lerAno(int ano)
	{
		List<Ficha> fichaMes = new ArrayList<>();
		for(Ficha f : fichas)
		{
			if(f.getDataConsumo().getYear() == ano)
			{
				fichaMes.add(f);
			}
		}
		return fichaMes;
	}

	@Override
	public void remover(Ficha ficha) throws ElementoNaoExisteException 
	{
		if(this.fichas.contains(ficha))
		{
			this.fichas.remove(this.fichas.indexOf(ficha));
		}
		else
		{
			throw new ElementoNaoExisteException(ficha);
		}
	}

	@Override
	public void atualizar(Ficha atual, Ficha novoConteudo) throws ElementoNaoExisteException 
	{
		if(this.fichas.contains(atual))
		{
			int indice = this.fichas.indexOf(atual);
			this.fichas.set(indice, novoConteudo);
		}
		else
		{
			throw new ElementoNaoExisteException(novoConteudo);
		}
	}
	
}
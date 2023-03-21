package br.com.ru.negocio;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import br.com.ru.dados.IRepositorioGenerico;
import br.com.ru.dados.RepositorioFicha;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;

public class ControladorFicha {
	private IRepositorioGenerico<Ficha> repositorioFicha;
	private static ControladorFicha instancia;
	private List<Ficha> listaFicha;
	
	public ControladorFicha() {
		this.repositorioFicha = new RepositorioFicha(listaFicha);
	}
	
	
	// Garantir unica instancia da classe
	public static ControladorFicha getInstancia()
	{
		if(instancia == null)
		{
			instancia = new ControladorFicha();
		}
		return instancia;
	}	
	
	// Metodo para adicionar fichas
	public void comprarFicha (double preco, double dinheiroCliente, Cliente cliente) 
			throws ElementoJaExisteException, SaldoInsuficienteException
	{
		
		SecureRandom randomico = new SecureRandom();
		if(preco != 0.0 && cliente != null)
		{
			if(dinheiroCliente <= cliente.getSaldo())
			{
				for(int i = 0; i < Math.floor(dinheiroCliente / preco); i++)
				{
					String codigo = "";
					codigo += (100000000 + randomico.nextLong(900000000));
					Ficha novoFicha = new Ficha( cliente, codigo);
					repositorioFicha.inserir(novoFicha);
					cliente.debitar(preco);
					cliente.aumentarNumeroFichas();
				}
			}
			else
			{
				throw new SaldoInsuficienteException(dinheiroCliente);
			}
		}
	}
	
	// Metodo para mostrar fichas
	public List<Ficha> listarFichas()
	{
		return repositorioFicha.ler();
	}
	
	// Metodo para mostrar fichas mais novas
	public List<Ficha> listarFichasRecentes()
	{
		List<Ficha> atual = repositorioFicha.ler();
		List<Ficha> nova = new ArrayList<>();
		for(int i = atual.size(); i >= 0; i--)
		{
			nova.add(atual.get(i));
		}
		return ((RepositorioFicha) nova).ler();
	}
	
	// Metodo para remover ficha
	public void gastarFicha (Ficha ficha) 
			throws ElementoNaoExisteException
	{
		if(ficha != null)
		{
			repositorioFicha.remover(ficha);
			ficha.getCliente().diminuirNumeroFichas();
		}
	}
	
	public Ficha recuperarFicha(String codigo) throws ElementoNaoExisteException {
		// Busca a ficha pelo codigo
		List<Ficha> fichas = repositorioFicha.ler();
		for (Ficha f : fichas) {
			if (f.getCodigo().equals(codigo)) {
				return f;
			}
		}
		// Caso não encontre, lança exceção
		throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
	}
	
	// Metodo para atualizar ficha
	public void atualizarFicha (double preco, Cliente cliente, String codigo) 
					throws ElementoNaoExisteException
	{
		
		Ficha pratoAtual = recuperarFicha(codigo);
		
		if(pratoAtual != null)
		{
			Ficha novoFicha = new Ficha(cliente, codigo);
			if(!pratoAtual.equals(novoFicha) && novoFicha != null)
			{
				repositorioFicha.atualizar(pratoAtual, novoFicha);
			}
		}
	}
	
	public List<Ficha> listarFichaPorCliente(Cliente cliente) throws ElementoNaoExisteException {
		// Busca a ficha pelo codigo
		List<Ficha> fichas = repositorioFicha.ler();
		List<Ficha> fichasDoCliente = new ArrayList<>();
		for (Ficha f : fichas) {
			if (f.getCliente().equals(cliente)) {
				fichasDoCliente.add(f);
			}
		}
		return Collections.unmodifiableList(fichasDoCliente);
	}
	
	public Ficha recuperarFichaDoCliente(Cliente cliente) throws ElementoNaoExisteException {
		// Busca a ficha pelo codigo
		List<Ficha> fichas = repositorioFicha.ler();
		for (Ficha f : fichas) {
			if (f.getCliente().equals(cliente)) {
				return f;
			}
		}
		return null;
	}
}

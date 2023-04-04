package br.com.ru.negocio;

import java.security.SecureRandom;
import java.time.LocalDateTime;
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
import br.com.ru.negocio.models.Ficha.StatusFicha;
import br.com.ru.negocio.models.ItemConsumivel;
import br.com.ru.negocio.models.Refeicao;

public class ControladorFicha {
	private IRepositorioGenerico<Ficha> repositorioFicha;
	private static ControladorFicha instancia;
	private List<Ficha> listaFicha;
	
	private ControladorFicha() {
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
	
	// Metodo para cadastrar fichas
	private void cadastrarFicha () throws ElementoJaExisteException 
	{
		List<Ficha> listaFicha = repositorioFicha.ler();
		SecureRandom randomico = new SecureRandom();
		for(int i = 0; i < 100; i++)
		{
			boolean liberado = true;
			String codigo = "";
			String codigoPossivel = "";
			do
			{
				codigoPossivel = codigo + (100000000 + randomico.nextLong(900000000));
				for(Ficha f : listaFicha)
				{
					if(codigoPossivel.equals(f.getCodigo()))
					{
						liberado = false;
					}
				}
			}while(!liberado);
			codigo += codigoPossivel;
			Ficha novoFicha = new Ficha(codigo);
			repositorioFicha.inserir(novoFicha);
		}
	}
	
	
	// Metodo para comprar fichas
	public void comprarFicha (double preco, double dinheiroCliente, Cliente cliente) 
			throws ElementoJaExisteException, SaldoInsuficienteException
	{
		int sent = 0;
		List<Ficha> listaFicha = repositorioFicha.ler();
		if(preco != 0.0 && cliente != null && dinheiroCliente <= cliente.getSaldo())
		{
			double precoTotalParaPagar = Math.floor(dinheiroCliente / preco) * preco;
			do
			{
				for(Ficha f : listaFicha)
				{
					if(f.getCliente() == null && sent < Math.floor(dinheiroCliente / preco))
					{
							sent++;
							f.setCliente(cliente);
							f.setStatusFicha(StatusFicha.EFETIVADA);
							f.setDataEfetivacao(LocalDateTime.now());
					}
				}
				if(sent != Math.floor(dinheiroCliente / preco))
				{
					cadastrarFicha();
				}
			}while(sent != Math.floor(dinheiroCliente / preco));
			cliente.debitar(precoTotalParaPagar);
		}
		else
		{
			throw new SaldoInsuficienteException(dinheiroCliente);
		}
	}
	
	// Metodo para mostrar fichas
	public List<Ficha> listarFichas()
	{
		return repositorioFicha.ler();
	}
	
	// Metodo para remover ficha
	public void gastarFicha (Ficha ficha, List<ItemConsumivel> refeicao)
			throws ElementoNaoExisteException
	{
		if(ficha != null && ficha.getCliente() != null && ficha.getStatusFicha() == StatusFicha.EFETIVADA)
		{
			ficha.setDataConsumo(LocalDateTime.now());
			ficha.setStatusFicha(StatusFicha.CONSUMIDA);
			ficha.setRefeicao((Refeicao) refeicao);
		}
	}
	
	public Ficha recuperarFicha(String codigo) throws ElementoNaoExisteException {
		// Busca a ficha pelo codigo
		List<Ficha> listaFicha = repositorioFicha.ler();
		for (Ficha f : listaFicha) {
			if (f.getCodigo().equals(codigo)) {
				return f;
			}
		}
		// Caso não encontre, lança exceção
		throw new ElementoNaoExisteException("Não existe um cliente com esse CPF!");
	}
	
	// Metodo para atualizar ficha
	public void atualizarPrecoFicha (double preco)
	{
		if(preco > 0.0)
		{
			Ficha.setPreco(preco);
		}
	}
	
	public List<Ficha> listarFichaPorCliente(Cliente cliente) throws ElementoNaoExisteException {
		// Busca a ficha pelo codigo
		List<Ficha> listaFicha = repositorioFicha.ler();
		List<Ficha> fichasDoCliente = new ArrayList<>();
		for (Ficha f : listaFicha) {
			if (f.getCliente().equals(cliente) && f.getStatusFicha() == StatusFicha.EFETIVADA) {
				fichasDoCliente.add(f);
			}
		}
		return Collections.unmodifiableList(fichasDoCliente);
	}
	
	public int numeroDeFichaPorCliente(Cliente cliente) throws ElementoNaoExisteException
	{
		if(cliente != null)
		{
			int numeroFichas = 0;
			List<Ficha> listaFicha = repositorioFicha.ler();
			for(Ficha f : listaFicha)
			{
				if(f.getCliente().equals(cliente) && f.getStatusFicha() == StatusFicha.EFETIVADA)
				{
					numeroFichas++;
				}
			}
			return numeroFichas;
		}
		else
		{
			throw new ElementoNaoExisteException(cliente);
		}
	}
	
	public Ficha recuperarFichaDoCliente(Cliente cliente) throws ElementoNaoExisteException {
		// Busca a ficha pelo codigo
		List<Ficha> listaFicha = repositorioFicha.ler();
		for (Ficha f : listaFicha) {
			if (f.getCliente().equals(cliente) && f.getStatusFicha() == StatusFicha.EFETIVADA) {
				return f;
			}
		}
		return null;
	}
	
	public List<Ficha> listarFichaPorPeriodo(int mes)
	{
		List<Ficha> listaFicha = repositorioFicha.ler();
		List<Ficha> fichaMes = new ArrayList<>();
		for(Ficha f : listaFicha)
		{
			if(f.getDataConsumo().getMonthValue() == mes)
			{
				fichaMes.add(f);
			}
		}
		return fichaMes;
	}
}

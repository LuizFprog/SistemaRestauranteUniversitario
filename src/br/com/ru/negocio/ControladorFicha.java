package br.com.ru.negocio;

import java.security.SecureRandom;
import java.time.LocalDate;
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

public class ControladorFicha {
	private IRepositorioGenerico<Ficha> repositorioFicha;
	private static ControladorFicha instancia;
	private List<Ficha> listaFicha;

	private ControladorFicha() {
		this.repositorioFicha = new RepositorioFicha(listaFicha);
	}

	// Garantir unica instancia da classe
	public static ControladorFicha getInstancia() {
		if (instancia == null) {
			instancia = new ControladorFicha();
		}
		return instancia;
	}

	// Metodo para cadastrar fichas
	public void cadastrarFicha(double preco) throws ElementoJaExisteException {
		List<Ficha> listaFicha = repositorioFicha.ler();
		SecureRandom randomico = new SecureRandom();
		for (int i = 0; i < 100; i++) {
			boolean liberado = true;
			String codigo = "";
			String codigoPossivel = "";
			do {
				codigoPossivel = codigo + (100000000 + randomico.nextLong(900000000));
				for (Ficha f : listaFicha) {
					if (codigoPossivel.equals(f.getCodigo())) {
						liberado = false;
					}
				}
			} while (!liberado);
			codigo += codigoPossivel;
			Ficha novoFicha = new Ficha(codigo, preco);
			repositorioFicha.inserir(novoFicha);
		}
	}

	// Metodo para comprar fichas
	public void comprarFicha(double preco, double dinheiroCliente, Cliente cliente)
			throws ElementoJaExisteException, SaldoInsuficienteException {
		System.out.println(preco + " " + dinheiroCliente);
		int sent = 0;
		List<Ficha> listaFicha = repositorioFicha.ler();
		if (preco != 0.0 && cliente != null && dinheiroCliente <= cliente.getSaldo()) {
			double precoTotalParaPagar = Math.floor(dinheiroCliente / preco) * preco;
			do {
				for (Ficha f : listaFicha) {
					if (f.getCliente() == null && sent < Math.floor(dinheiroCliente / preco)) {
						sent++;
						f.setCliente(cliente);
						f.setStatusFicha(StatusFicha.EFETIVADA);
						f.setDataEfetivacao(LocalDate.now());
					}
				}
				if (sent != Math.floor(dinheiroCliente / preco)) {
					cadastrarFicha(preco);
				}
			} while (sent != Math.floor(dinheiroCliente / preco));
			cliente.debitar(precoTotalParaPagar);
		} else {
			throw new SaldoInsuficienteException(dinheiroCliente);
		}
	}

	// Metodo para mostrar fichas
	public List<Ficha> listarFichas() {
		return repositorioFicha.ler();
	}

	// Metodo para remover ficha
	public void gastarFicha(Ficha ficha) throws ElementoNaoExisteException {
		if (ficha != null && ficha.getCliente() != null && ficha.getStatusFicha() == StatusFicha.EFETIVADA) {
			ficha.setDataConsumo(LocalDate.now());
			ficha.setStatusFicha(StatusFicha.CONSUMIDA);
		}
	}

	public Ficha retornarFichaNaoEfetivada() {
		List<Ficha> atual = repositorioFicha.ler();

		for (Ficha i : atual) {
			if (i.getStatusFicha() == StatusFicha.NAO_OPERANTE) {
				return i;
			}
		}
		return null;
	}

	public Ficha retornarFichaEfetivada() {
		List<Ficha> atual = repositorioFicha.ler();

		for (Ficha i : atual) {
			if (i.getStatusFicha() == StatusFicha.EFETIVADA) {
				return i;
			}
		}
		return null;
	}

	public Ficha retornarFichaConsumida() {
		List<Ficha> atual = repositorioFicha.ler();

		for (Ficha i : atual) {
			if (i.getStatusFicha() == StatusFicha.CONSUMIDA) {
				return i;
			}
		}
		return null;
	}

	public Ficha retornarFicha() {
		List<Ficha> atual = repositorioFicha.ler();

		for (Ficha i : atual) {
			if (i != null) {
				return i;
			}
		}
		return null;
	}

	// Metodo para atualizar ficha
	public void atualizarPrecoFicha(double preco) {
		List<Ficha> atual = repositorioFicha.ler();
		if (preco >= 0.0) {
			for (Ficha i : atual) {
				if (i.getStatusFicha() == StatusFicha.NAO_OPERANTE) {
					i.setPreco(preco);
					
				}
			}
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

	public int numeroDeFichaPorCliente(Cliente cliente) throws ElementoNaoExisteException {
		if (cliente != null) {
			int numeroFichas = 0;
			List<Ficha> listaFicha = repositorioFicha.ler();
			for (Ficha f : listaFicha) {
				if (f.getCliente().equals(cliente) && f.getStatusFicha() == StatusFicha.EFETIVADA) {
					numeroFichas++;
				}
			}
			return numeroFichas;
		} else {
			throw new ElementoNaoExisteException(cliente);
		}
	}

	public Ficha recuperarFichaDoCliente(Cliente cliente) throws ElementoNaoExisteException {
		// Busca a ficha pelo codigo
		List<Ficha> listaFicha = repositorioFicha.ler();
		for (Ficha f : listaFicha) {
			if (f.getCliente().equals(cliente)
					&& (f.getStatusFicha() == StatusFicha.EFETIVADA || f.getStatusFicha() == StatusFicha.CONSUMIDA)) {
				return f;
			}
		}
		throw new ElementoNaoExisteException(cliente);
	}

	public Ficha recuperarFichaEfetivaDoCliente(Cliente cliente) throws ElementoNaoExisteException {
		// Busca a ficha pelo codigo
		List<Ficha> listaFicha = repositorioFicha.ler();
		for (Ficha f : listaFicha) {
			if (f.getCliente().equals(cliente) && f.getStatusFicha() == StatusFicha.EFETIVADA) {
				return f;
			}
		}
		throw new ElementoNaoExisteException(cliente);
	}

	public List<Ficha> listarFichaPorDia(int dia) {
		return ((RepositorioFicha) repositorioFicha).lerDia(dia);
	}

	public List<Ficha> listarFichaPorMes(int mes) {
		return ((RepositorioFicha) repositorioFicha).lerMes(mes);
	}

	public List<Ficha> listarFichaPorAno(int ano) {
		return ((RepositorioFicha) repositorioFicha).lerAno(ano);
	}
}

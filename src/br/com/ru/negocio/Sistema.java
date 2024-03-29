package br.com.ru.negocio;

import java.util.List;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.ItemConsumivel;
import br.com.ru.negocio.models.ItemConsumivel.TipoCardapio;
import br.com.ru.negocio.models.Usuario;

public class Sistema {

	private ControladorUsuario controladorUsuario;
	private ControladorItemConsumivel controladorItemConsumivel;
	private ControladorFicha controladorFicha;
	private static Sistema instancia;

	private Sistema() {
		this.controladorUsuario = ControladorUsuario.getInstancia();
		this.controladorItemConsumivel = ControladorItemConsumivel.getInstancia();
		this.controladorFicha = ControladorFicha.getInstancia();
	}

	// Garantir unica instancia da classe
	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}

	// ####################
	// Metodos Cliente
	// ####################

	// Você deve passar os parametros e esse metodo chamara um metodo para adicionar
	// um cliente inicializado com tais
	// parametros ao repositorio
	public void adicionarCliente(String primeiroNome, String ultimoNome, String cpf, String login, String senha)
			throws ElementoJaExisteException {
		if (cpf != null && login != null && senha != null && primeiroNome != null && ultimoNome != null) {
			controladorUsuario.criarCliente(primeiroNome, ultimoNome, cpf, login, senha);
		}
	}

	// Procura Cliente atraves de cpf passado como parametro e retorna uma string
	// para listar esse cliente
	public String procurarClienteEspecifico(String cpf) throws ElementoNaoExisteException {
		return controladorUsuario.listarClienteEspecifico(cpf);
	}

	// Procura Cliente atraves de cpf passado como parametro e retorna o objeto
	// desse cliente
	public Usuario recuperarClienteEspecifico(String cpf) throws ElementoNaoExisteException {
		return controladorUsuario.recuperarUsuario(cpf);
	}

	// Procura o cliente atraves do cpf e o atualiza com os parametros passados
	public void atualizarCliente(String cpfAtual, String primeiroNome, String ultimoNome, String login, String senha)
			throws ElementoNaoExisteException {
		if (cpfAtual != null && login != null && senha != null && primeiroNome != null && ultimoNome != null) {
			controladorUsuario.atualizarCliente(cpfAtual, primeiroNome, ultimoNome, login, senha);
		}
	}

	// Procura o cliente atraves do cpf e o remove do repositorio
	public void removerCliente(String cpf) throws ElementoNaoExisteException {
		controladorUsuario.excluirCliente(cpf);
	}

	// Deposita um valor passado como parametro em uma conta com o cpf colocado como
	// parametro
	public void depositar(double valor, String cpf) throws ElementoNaoExisteException {
		controladorUsuario.depositarDinheiro(valor, cpf);
	}

	// Retorna apenas os clientes do repositorio de usuarios
	public List<Cliente> listarTodosClientes() {
		return controladorUsuario.listarTodosClientes();
	}

	// Debita um valor passado como parametro em uma conta com o cpf colocado como
	// parametro,
	// apenas se o valor for menor que o saldo do cliente
	public void debitar(double valor, String cpf) throws ElementoNaoExisteException {
		controladorUsuario.debitarDinheiro(valor, cpf);
	}

	// ####################
	// Metodos Funcionario
	// ####################

	// Recebe um cpf e retorna uma String do cliente que possui o cpf
	public String listarFuncionarioEspecifico(String cpf) throws ElementoNaoExisteException {

		return controladorUsuario.listarTrabalhadorEspecifico(cpf);
	}

	// Retorna apenas os funcionarios do repositorio de usuarios
	public List<Funcionario> listarTodosFuncionarios() {
		return controladorUsuario.listarTodosFuncionarios();
	}

	// Retorna todos os usuarios
	public List<Usuario> listarTodosUsuarios() {
		return controladorUsuario.listarUsuarios();
	}

	// Inicializa um funcionario com os parametros passados
	public void adicionarFuncionario(String primeiroNome, String ultimoNome, String cpf, String login, String senha,
			String id) throws ElementoJaExisteException {
		if (cpf != null && login != null && senha != null && primeiroNome != null && ultimoNome != null && id != null) {
			controladorUsuario.adicionarFuncionario(primeiroNome, ultimoNome, cpf, login, senha, id);
		}

	}

	// Retorna um usuario que possua o cpf passado como parametro
	public Usuario recuperarFuncionarioEspecifico(String cpf) throws ElementoNaoExisteException {

		return controladorUsuario.recuperarFuncionario(cpf);
	}

	// Atualiza um funcionario que possua o cpf passado como parametro com as
	// informações, também passadas como parametro
	public void atualizarFuncionario(String cpfAtual, String primeiroNome, String ultimoNome, String login,
			String senha, String id) throws ElementoNaoExisteException {
		if (cpfAtual != null && login != null && senha != null && primeiroNome != null && ultimoNome != null
				&& id != null) {
			controladorUsuario.atualizarFuncionario(cpfAtual, primeiroNome, ultimoNome, login, senha, id);
		}
	}

	// Exclui um funcionario que possua o cpf passado como parametro
	public void excluirFuncionario(String cpf) throws ElementoNaoExisteException {
		controladorUsuario.excluirFuncionario(cpf);
	}

	// ###############
	// Metodos USUARIO
	// ###############

	public Usuario recuperarUsuarioEspecifico(String cpf) throws ElementoNaoExisteException {

		return controladorUsuario.recuperarUsuario(cpf);
	}

	public Usuario recuperarUsuarioEspecificoAtravesLoginSenha(String login, String senha)
			throws ElementoNaoExisteException {

		return controladorUsuario.recuperarLoginSenha(login, senha);
	}

	// ######################
	// Metodos ItemConsumivel
	// ######################

	// Adiciona um itemConsumivel com as informações passadas como parametro
	public void adicionarItemConsumivel(String nome, boolean gluten, boolean lactose, TipoCardapio tipoItemConsumivel,
			boolean visivel) throws ElementoJaExisteException {
		controladorItemConsumivel.adicionarItemConsumivel(nome, gluten, lactose, tipoItemConsumivel, visivel);
	}

	// Retorna os itemConsumivels que aparecem no cardapio
	public List<ItemConsumivel> cardapio() {
		return controladorItemConsumivel.mostrarCardapio();
	}

	// Retorna todos os itemConsumivels
	public List<ItemConsumivel> verTodosItemConsumiveis() {
		return controladorItemConsumivel.listarTodosItemConsumiveis();
	}

	public List<ItemConsumivel> cardapioTrivial() {
		return controladorItemConsumivel.cardapioTrivial();
	}

	public String listaCardapioTrivial() {
		return controladorItemConsumivel.listaCardapioTrivial();
	}

	public List<ItemConsumivel> cardapioVegano() {
		return controladorItemConsumivel.cardapioVegano();
	}

	public List<ItemConsumivel> cardapioSuco() {
		return controladorItemConsumivel.cardapioSuco();
	}

	public List<ItemConsumivel> cardapioSobremesa() {
		return controladorItemConsumivel.cardapioSobremesa();
	}

	// Atualiza itemConsumivel que possua o nomeAtual passado como parametro com as
	// informações, também passadas como parametro
	public void atualizarItemConsumivel(String nomeAtual, String nome, boolean gluten, boolean lactose,
			TipoCardapio tipoItemConsumivel, boolean visivel) throws ElementoNaoExisteException {
		controladorItemConsumivel.atualizarItemConsumivel(nomeAtual, nome, gluten, lactose, tipoItemConsumivel,
				visivel);
	}

	// Remove um itemConsumivel com o nome passado como parametro do repositorio
	public void removerItemConsumivel(String nome) throws ElementoNaoExisteException {
		controladorItemConsumivel.removerItemConsumivel(nome);
	}

	// Retorna um itemConsumivel que possui o nome passado como parametro
	public ItemConsumivel recuperarItemConsumivel(String nome) throws ElementoNaoExisteException {
		return controladorItemConsumivel.recuperarItemConsumivel(nome);
	}

	// Adiciona um itemConsumivel passado como parametro ao cardapio
	public void colocarNoCardapio(ItemConsumivel itemConsumivel)
			throws ElementoNaoExisteException, NullPointerException {
		controladorItemConsumivel.itemConsumivelVisivel(itemConsumivel);
	}

	// Remove um itemConsumivel passado como parametro do cardapio
	public void removerDoCardapio(ItemConsumivel itemConsumivel) throws ElementoNaoExisteException {
		controladorItemConsumivel.itemConsumivelNaoVisivel(itemConsumivel);
	}

	// #############
	// Metodos Ficha
	// #############

	// Adiciona uma ficha com as informações passadas como parametro
	public void adicionarFicha(double preco, double dinheiroCliente, Usuario cliente)
			throws ElementoJaExisteException, SaldoInsuficienteException {
		if (cliente instanceof Cliente) {
			controladorFicha.comprarFicha(preco, dinheiroCliente, (Cliente) cliente);
		}
	}

	public void gastarFicha(Ficha ficha) throws ElementoNaoExisteException {
		controladorFicha.gastarFicha(ficha);
	}

	// Retorna uma lista de todas as fichas
	public List<Ficha> listarFicha() {
		return controladorFicha.listarFichas();
	}

	public Ficha retornarFicha() {
		return controladorFicha.retornarFichaNaoEfetivada();
	}

	public void gerarFicha() throws ElementoJaExisteException {
		if (controladorFicha.retornarFicha() != null && controladorFicha.retornarFichaNaoEfetivada() != null) {
			controladorFicha.cadastrarFicha(controladorFicha.retornarFichaNaoEfetivada().getPreco());
		} else if (controladorFicha.retornarFicha() != null && controladorFicha.retornarFichaEfetivada() != null) {
			controladorFicha.cadastrarFicha(controladorFicha.retornarFichaEfetivada().getPreco());
		} else if (controladorFicha.retornarFicha() != null && controladorFicha.retornarFichaConsumida() != null) {
			controladorFicha.cadastrarFicha(controladorFicha.retornarFichaEfetivada().getPreco());
		} else {
			controladorFicha.cadastrarFicha(0);
		}
	}

	// Listar por dia
	public List<Ficha> fichaPorDia(int dia) {
		return controladorFicha.listarFichaPorDia(dia);
	}

	// Listar por mes
	public List<Ficha> fichaPorMes(int mes) {
		return controladorFicha.listarFichaPorMes(mes);
	}

	// Listar por mes
	public List<Ficha> fichaPorAno(int ano) {
		return controladorFicha.listarFichaPorAno(ano);
	}

	// Retorna uma lista de todas as fichas do cliente passado como parametro
	public List<Ficha> listarFichaPorCliente(Usuario cliente) throws ElementoNaoExisteException {
		if (cliente instanceof Cliente) {
			return controladorFicha.listarFichaPorCliente((Cliente) cliente);
		}
		return null;
	}

	// Recupera ficha especifica do cliente
	public Ficha recuperarFichaDoCliente(Usuario cliente) throws ElementoNaoExisteException {
		if (cliente instanceof Cliente) {
			return controladorFicha.recuperarFichaDoCliente((Cliente) cliente);
		}
		return null;
	}

	public Ficha recuperarFichaEfetivaDoCliente(Usuario cliente) throws ElementoNaoExisteException {
		if (cliente instanceof Cliente) {
			return controladorFicha.recuperarFichaEfetivaDoCliente((Cliente) cliente);
		}
		return null;
	}

	// Retorna o número de fichas do cliente
	public int numeroDeFichaPorCliente(Usuario cliente) throws ElementoNaoExisteException {
		if (cliente instanceof Cliente) {
			return controladorFicha.numeroDeFichaPorCliente((Cliente) cliente);
		}
		return 0;
	}

	// Atualiza o preço da ficha
	public void atualizarPrecoFicha(double preco) {
		controladorFicha.atualizarPrecoFicha(preco);
	}
}

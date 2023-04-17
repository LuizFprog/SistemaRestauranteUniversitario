package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaPrincipalClienteController implements Initializable {

	@FXML
	private Button botaoCardapio;

	@FXML
	private Button botaoDepositar;

	@FXML
	private Button botaoFicha;

	@FXML
	private Button botaoSair;

	@FXML
	private Button botaoRemoverConta;

	@FXML
	private static TelaPrincipalClienteController instancia;

	@FXML
	private Button botaoInicio;

	@FXML
	private Sistema meuSistema = Sistema.getInstancia();

	@FXML
	private TextField campoTextoCpfCliente;

	@FXML
	private TextField campoTextoLoginCliente;

	@FXML
	private TextField campoTextoNomeCliente;

	@FXML
	private TextField campoTextoSaldoAtual;

	@FXML
	private TextField campoTextoSenhaCliente;

	@FXML
	private TextField campoTextoValorDepositar;

	@FXML
	private TextField campoTextoCpfParaRemover;

	@FXML
	private static Cliente cliente;

	@FXML
	private VBox vBox;

	@FXML
	public static TelaPrincipalClienteController getInstancia() {
		if (instancia == null) {
			instancia = new TelaPrincipalClienteController();
		}
		return instancia;
	}

	@FXML
	private TelaFichasClienteController clienteAtual = TelaFichasClienteController.getInstancia();

	@FXML
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		TelaPrincipalClienteController.cliente = cliente;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		campoTextoCpfCliente.setText(cliente.getCpf());
		campoTextoLoginCliente.setText(cliente.getLogin());
		campoTextoNomeCliente.setText(cliente.getPrimeiroNome() + " " + cliente.getUltimoNome());
		campoTextoSenhaCliente.setText(cliente.getSenha());
		campoTextoSaldoAtual.setText(String.valueOf(cliente.getSaldo()));

	}

	@FXML
	private void mostrarAlerta() {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("ERROR");
		alerta.setHeaderText("ERROR DEPOSITO");
		alerta.setContentText("erro ao depositar");
		alerta.showAndWait();

	}

	@FXML
	private void mostrarAlertaRemocao() {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("ERROR");
		alerta.setHeaderText("ERROR NO GERENCIAMENTO DE CONTA");
		alerta.setContentText("erro ao deletar conta");
		alerta.showAndWait();

	}

	@FXML
	public void irCardapio(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCardapioCliente.fxml"));
		Parent telaParent = loader.load();
		Scene telaCardapioParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaCardapioParent);
		janela.show();
	}

	@FXML
	public void recarregarTelaPrincipal(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipalCliente.fxml"));
		Parent telaParent = loader.load();
		Scene telaClientParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaClientParent);
		janela.show();
	}

	@FXML
	public void irFichas(ActionEvent event) throws Exception {
		clienteAtual.setCliente(cliente);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaFichasCliente.fxml"));
		Parent telaParent;
		telaParent = loader.load();
		Scene telaFichasParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaFichasParent);
		janela.show();
	}

	@FXML
	public void sairLogin(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLoginPrincipal.fxml"));
		Parent telaParent = loader.load();
		Scene telaLoginParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaLoginParent);
		janela.show();
	}

	@FXML
	public void acaoDepositar(ActionEvent event) throws Exception {

		try {
			Double valor = Double.valueOf(campoTextoValorDepositar.getText()).doubleValue();
			meuSistema.depositar(valor, cliente.getCpf());
			String novoSaldo = String.valueOf(cliente.getSaldo());

			campoTextoSaldoAtual.setText(novoSaldo);
			recarregarTelaPrincipal(event);

		} catch (NumberFormatException | ElementoNaoExisteException e) {
			mostrarAlerta();
			recarregarTelaPrincipal(event);
		}
	}

	@FXML
	public void acaoRemoverConta(ActionEvent event) throws Exception {

		@SuppressWarnings("unused")
		Usuario usuario;
		try {
			if (!campoTextoCpfParaRemover.getText().isEmpty()) {
				usuario = meuSistema.recuperarUsuarioEspecifico(campoTextoCpfParaRemover.getText());
				meuSistema.removerCliente(campoTextoCpfParaRemover.getText());
				sairLogin(event);
			}
		} catch (ElementoNaoExisteException e) {
			mostrarAlertaRemocao();
		}

	}

}

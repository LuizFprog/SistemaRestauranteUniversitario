package br.com.ru.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.negocio.Sistema;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class TelaCadastroClienteController {

	@FXML
	private Sistema meuSistema = Sistema.getInstancia();

	@FXML
	private Button botaoCadastrarCliente;

	@FXML
	private Button botaoCancelar;

	@FXML
	private TextField campoTextoCpf;

	@FXML
	private TextField campoTextoLogin;

	@FXML
	private TextField campoTextoPrimeiroNome;

	@FXML
	private TextField campoTextoSenha;

	@FXML
	private TextField campoTextoUltimoNome;

	@FXML
	public void atualizarCliente(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroCliente.fxml"));
		Parent telaClienteParent = loader.load();
		Scene telaClienteScene = new Scene(telaClienteParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaClienteScene);
		janela.show();
	}

	@FXML
	private void mostrarAlerta() {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("ERROR");
		alerta.setHeaderText("ERRO AO CADASTRAR");
		alerta.setContentText("Todos os campos devem estar preenchidos.");
		alerta.showAndWait();
	}

	@FXML
	private void mostrarAlertaElementoExiste() {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("ERROR");
		alerta.setHeaderText("ERRO AO CADASTRAR");
		alerta.setContentText("Elemento já existe.");
		alerta.showAndWait();
	}

	@FXML
	public void cadastrar(ActionEvent event) throws Exception {
		String primeiroNome = null;
		String ultimoNome = null;
		String cpf = null;
		String login = null;
		String senha = null;

		if (!campoTextoPrimeiroNome.getText().isEmpty() && !campoTextoUltimoNome.getText().isEmpty()
				&& !campoTextoCpf.getText().isEmpty() && !campoTextoLogin.getText().isEmpty()
				&& !campoTextoSenha.getText().isEmpty()) {
			primeiroNome = campoTextoPrimeiroNome.getText();
			ultimoNome = campoTextoUltimoNome.getText();
			cpf = campoTextoCpf.getText();
			login = campoTextoLogin.getText();
			senha = campoTextoSenha.getText();
		}

		try {
			meuSistema.adicionarCliente(primeiroNome, ultimoNome, cpf, login, senha);
			voltarLogin(event);
		} catch (ElementoJaExisteException e) {
			mostrarAlertaElementoExiste();
			atualizarCliente(event);
		}

	}

	@FXML
	public void voltarLogin(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLoginPrincipal.fxml"));
		Parent telaLoginParent = loader.load();
		Scene telaLoginScene = new Scene(telaLoginParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaLoginScene);
		janela.show();
	}

}

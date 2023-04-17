package br.com.ru.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.negocio.Sistema;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaCadastroFuncionarioController {

	@FXML
	private Sistema meuSistema = Sistema.getInstancia();

	@FXML
	private Button botaoCadastrarFuncionario;

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
	private TextField campoTextoId;

	@FXML
	public void atualizarFuncionario(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroFuncionario.fxml"));
		Parent telaFuncionarioParent = loader.load();
		Scene telaFuncionarioScene = new Scene(telaFuncionarioParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaFuncionarioScene);
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
	private void mostrarAlertaJaExiste() {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("ERROR");
		alerta.setHeaderText("ERRO AO CADASTRAR");
		alerta.setContentText("Usuario já existe.");
		alerta.showAndWait();
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

	@FXML
	public void cadastrar(ActionEvent event) throws Exception {

		String primeiroNome = null;
		String ultimoNome = null;
		String cpf = null;
		String login = null;
		String senha = null;
		String id = null;

		if (!campoTextoPrimeiroNome.getText().isEmpty() && !campoTextoUltimoNome.getText().isEmpty()
				&& !campoTextoCpf.getText().isEmpty() && !campoTextoLogin.getText().isEmpty()
				&& !campoTextoSenha.getText().isEmpty() && !campoTextoId.getText().isEmpty()) {
			primeiroNome = campoTextoPrimeiroNome.getText();
			ultimoNome = campoTextoUltimoNome.getText();
			cpf = campoTextoCpf.getText();
			login = campoTextoLogin.getText();
			senha = campoTextoSenha.getText();
			id = campoTextoId.getText();
		}

		try {
			meuSistema.adicionarFuncionario(primeiroNome, ultimoNome, cpf, login, senha, id);
			voltarLogin(event);
		} catch (ElementoJaExisteException e) {
			mostrarAlertaJaExiste();
			atualizarFuncionario(event);
		}

	}

}

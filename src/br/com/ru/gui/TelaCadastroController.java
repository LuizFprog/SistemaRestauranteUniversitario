package br.com.ru.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaCadastroController {

	@FXML
	private Button botaoCancelar;

	@FXML
	private Button botaoCliente;

	@FXML
	private Button botaoFuncionario;

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
	public void irParaCliente(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroCliente.fxml"));
		Parent telaClienteParent = loader.load();
		Scene telaClienteScene = new Scene(telaClienteParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaClienteScene);
		janela.show();
	}

	@FXML
	public void irParaFuncionario(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroFuncionario.fxml"));
		Parent telaFuncionarioParent = loader.load();
		Scene telaFuncionarioScene = new Scene(telaFuncionarioParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaFuncionarioScene);
		janela.show();
	}

}

package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaPrincipalFuncionarioController implements Initializable {

	@FXML
	private Button botaoCardapio;

	@FXML
	private Sistema meuSistema = Sistema.getInstancia();

	@FXML
	private static TelaPrincipalFuncionarioController instancia;

	@FXML
	private Button botaoDados;

	@FXML
	private Button botaoInicio;

	@FXML
	private Button botaoItens;

	@FXML
	private TextField campoTextoCpfFunc;

	@FXML
	private TextField campoTextoIdFunc;

	@FXML
	private TextField campoTextoLoginFunc;

	@FXML
	private TextField campoTextoNomeFunc;

	@FXML
	private TextField campoTextoSenhaFunc;

	@FXML
	private static Funcionario funcionario;

	@FXML
	public static TelaPrincipalFuncionarioController getInstancia() {
		if (instancia == null) {
			instancia = new TelaPrincipalFuncionarioController();
		}
		return instancia;
	}

	public static Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		TelaPrincipalFuncionarioController.funcionario = funcionario;
	}

	@FXML
	public void entrarTelaDados(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaDadosFuncionario.fxml"));
		Parent telaParent = loader.load();
		Scene telaDadosParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaDadosParent);
		janela.show();
	}

	@FXML
	public void entrarTelaCardapio(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCardapioFuncionario.fxml"));
		Parent telaParent = loader.load();
		Scene telaDadosParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaDadosParent);
		janela.show();
	}

	@FXML
	public void entrarTelaItens(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaItemFuncionario.fxml"));
		Parent telaParent = loader.load();
		Scene telaItensParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaItensParent);
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		campoTextoCpfFunc.setText(funcionario.getCpf());
		campoTextoLoginFunc.setText(funcionario.getLogin());
		campoTextoNomeFunc.setText(funcionario.getPrimeiroNome() + " " + funcionario.getUltimoNome());
		campoTextoSenhaFunc.setText(funcionario.getSenha());
		campoTextoIdFunc.setText(funcionario.getId());

	}

}

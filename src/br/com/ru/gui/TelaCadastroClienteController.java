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
	private Button buttonCadastrarCliente;

	@FXML
	private Button buttonCancelar;
	
    @FXML
    private TextField textFieldCpf;

    @FXML
    private TextField textFieldLogin;

    @FXML
    private TextField textFieldPrimeiroNome;

    @FXML
    private TextField textFieldSenha;

    @FXML
    private TextField textFieldUltimoNome;
    
    @FXML
    public void reloadCliente(ActionEvent event) throws Exception {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroCliente.fxml"));
        Parent telaClienteParent = loader.load();
        Scene telaClienteScene = new Scene(telaClienteParent);
        Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janela.setScene(telaClienteScene);
        janela.show();
    }
    
    @FXML
    private void mostrarAlerta() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO CADASTRAR");
        alerta.setContentText("Todos os campos devem estar preenchidos.");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }
    
    @FXML
    private void mostrarAlertaElementoExiste() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO CADASTRAR");
        alerta.setContentText("Elemento já existe.");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }
    
    @FXML
    public void cadastrar(ActionEvent event) throws Exception
    {
    	String primeiroNome = null;
		String ultimoNome = null;
		String cpf = null;
		String login = null;
		String senha = null;
    	
    	if (!textFieldPrimeiroNome.getText().isEmpty() && !textFieldUltimoNome.getText().isEmpty() && !textFieldCpf.getText().isEmpty() && !textFieldLogin.getText().isEmpty() && !textFieldSenha.getText().isEmpty()) {
    		primeiroNome = textFieldPrimeiroNome.getText();
    		ultimoNome = textFieldUltimoNome.getText();
    		cpf = textFieldCpf.getText();
    		login = textFieldLogin.getText();
    		senha = textFieldSenha.getText();
    	}
    	
    	try {
			meuSistema.adicionarCliente(primeiroNome, ultimoNome, cpf, login, senha);
			voltarLogin(event);
		} catch (ElementoJaExisteException e) {
			mostrarAlertaElementoExiste();
			reloadCliente(event);
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

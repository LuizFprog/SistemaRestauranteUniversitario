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
	private Button buttonCadastrarFuncionario;

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
    private TextField textFieldId;
    
    @FXML
    public void reloadFuncionario(ActionEvent event) throws Exception {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroFuncionario.fxml"));
        Parent telaFuncionarioParent = loader.load();
        Scene telaFuncionarioScene = new Scene(telaFuncionarioParent);
        Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janela.setScene(telaFuncionarioScene);
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
   public void voltarLogin(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLoginPrincipal.fxml"));
        Parent telaLoginParent = loader.load();
        Scene telaLoginScene = new Scene(telaLoginParent);
        Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janela.setScene(telaLoginScene);
        janela.show();
    }
   
   @FXML
   public void cadastrar(ActionEvent event) throws Exception  {
   	
       String primeiroNome = null;   
       String ultimoNome = null;
       String cpf = null;
       String login = null;
       String senha = null;
       String id = null;
       
       if (!textFieldPrimeiroNome.getText().isEmpty() && !textFieldUltimoNome.getText().isEmpty() && !textFieldCpf.getText().isEmpty() && !textFieldLogin.getText().isEmpty() && !textFieldSenha.getText().isEmpty() && !textFieldId.getText().isEmpty()) {
   		primeiroNome = textFieldPrimeiroNome.getText();
   		ultimoNome = textFieldUltimoNome.getText();
   		cpf = textFieldCpf.getText();
   		login = textFieldLogin.getText();
   		senha = textFieldSenha.getText();
   		id = textFieldId.getText();
   	}
       
	   	try {
			meuSistema.adicionarFuncionario(primeiroNome, ultimoNome, cpf, login, senha, id);
			voltarLogin(event);
		} catch (ElementoJaExisteException e) {
			mostrarAlerta();
			reloadFuncionario(event);
		} catch (NullPointerException e) {
			mostrarAlerta();
			reloadFuncionario(event);
		}
   	
   }
    
}

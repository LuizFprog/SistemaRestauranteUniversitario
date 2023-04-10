package br.com.ru.gui;

import java.io.IOException;

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
    public void cadastrar(ActionEvent event) throws IOException, ElementoJaExisteException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroFuncionario.fxml"));
        Parent root = loader.load();
        
        TextField primeiroNomeTextField = (TextField) root.lookup("textFieldPrimeiroNome");
        String primeiroNome = primeiroNomeTextField.getText();
        
        TextField ultimoNomeTextField = (TextField) root.lookup("textFieldUltimoNome");
        String ultimoNome = ultimoNomeTextField.getText();
        
        TextField cpfTextField = (TextField) root.lookup("textFieldCpf");
        String cpf = cpfTextField.getText();
        
        TextField loginTextField = (TextField) root.lookup("textFieldLogin");
        String login = loginTextField.getText();
        
        TextField senhaTextField = (TextField) root.lookup("textFieldSenha");
        String senha = senhaTextField.getText();
        
        TextField idTextField = (TextField) root.lookup("textFieldId");
        String id = idTextField.getText();
        
    	meuSistema.adicionarFuncionario(primeiroNome, ultimoNome, cpf, login, senha, id);
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

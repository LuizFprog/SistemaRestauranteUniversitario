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
	
	private Sistema meuSistema = new Sistema();
	
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
    public void cadastrar(ActionEvent event) throws IOException, ElementoJaExisteException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroCliente.fxml"));
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
    
   public void voltarLogin(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLogin.fxml"));
        Parent telaLoginParent = loader.load();
        Scene telaLoginScene = new Scene(telaLoginParent);
        Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janela.setScene(telaLoginScene);
        janela.show();
    }
    
}

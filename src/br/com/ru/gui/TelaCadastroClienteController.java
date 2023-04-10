package br.com.ru.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import br.com.ru.negocio.Sistema;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    public void cadastrar(ActionEvent event) throws Exception
    {
    	String primeiroNome = textFieldPrimeiroNome.getText();
    	String ultimoNome = textFieldUltimoNome.getText();
    	String cpf = textFieldCpf.getText();
    	String login = textFieldLogin.getText();
    	String senha = textFieldSenha.getText();
    	
    	meuSistema.adicionarCliente(primeiroNome, ultimoNome, cpf, login, senha);
    	voltarLogin(event);
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

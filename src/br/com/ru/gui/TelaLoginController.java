package br.com.ru.gui;



import javafx.scene.control.TextField;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TelaLoginController {

	@FXML
    private Button botaoEntrar;
	
	@FXML
	private Button botaoCadastrar;

	@FXML
    private TextField textLogin;
	
	@FXML
    private TextField textSenha;

	@FXML
	private Sistema meuSistema = Sistema.getInstancia();
	
	@FXML
	private TelaPrincipalClienteController meuClienteAtivo = TelaPrincipalClienteController.getInstancia();
	
	@FXML
	private TelaPrincipalFuncionarioController meuFuncionarioAtivo = TelaPrincipalFuncionarioController.getInstancia();
	
	@FXML
	private void mostrarAlerta() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERROR LOGIN");
        alerta.setContentText("Usuario não cadastrado");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
        
    }
	
	@FXML
   public void reload(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLoginPrincipal.fxml"));
        Parent telaLoginParent = loader.load();
        Scene telaLoginScene = new Scene(telaLoginParent);
        Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janela.setScene(telaLoginScene);
        janela.show();
    }	
	
	@FXML
    public void entrarTelaFuncionario(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipalFuncionarios.fxml"));
        Parent telaFuncParent = loader.load();
        Scene telaFuncionarioParent = new Scene(telaFuncParent);
        Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janela.setScene(telaFuncionarioParent);
        janela.show();
    }
	
	@FXML
    public void entrarTelaCliente(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipalCliente.fxml"));
        Parent telaParent = loader.load();
        Scene telaClientParent = new Scene(telaParent);
        Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janela.setScene(telaClientParent);
        janela.show();
    }
	
	@FXML
    public void entrarTelaCadastro(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaTipoCadastro.fxml"));
        Parent telaParent = loader.load();
        Scene telaCadasParent = new Scene(telaParent);
        Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janela.setScene(telaCadasParent);
        janela.show();
    }
	
	@FXML
	public void acaoEntrar(ActionEvent event) throws Exception {
		
		String login = textLogin.getText(); //assumindo cpf
		String senha = textSenha.getText();
	
		if(!login.isEmpty() && !senha.isEmpty()) {
			
			Usuario usuario = null;
			try {
				usuario = meuSistema.recuperarUsuarioEspecificoAtravesLoginSenha(login, senha);
			} catch (ElementoNaoExisteException e) {
				mostrarAlerta();
				reload(event);
			}  
	
			
			if(usuario != null) {
				
				if(usuario instanceof Funcionario) {
					meuFuncionarioAtivo.setFuncionario((Funcionario) usuario);
					entrarTelaFuncionario(event);
					
				} else if(usuario instanceof Cliente) {
					meuClienteAtivo.setCliente((Cliente) usuario);
					entrarTelaCliente(event);
					
				}
			}
		}
	}
	
	
	
}

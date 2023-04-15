package br.com.ru.gui;



import javafx.scene.control.TextField;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	
		if(login != null && senha != null) {
			
			Usuario usuario = meuSistema.recuperarUsuarioEspecificoAtravesLoginSenha(login, senha);  //
	
			
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

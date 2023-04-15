package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerDadosFuncionario implements Initializable{
	@FXML
	private Sistema meuSistema = Sistema.getInstancia();

    @FXML
    private TableView<Ficha> listFichas;
    
    @FXML
    private Button buttonRemoveUser;
    
    @FXML
    private TextField textFieldCpfUser;    
    
    @FXML
  	public void sairLogin(ActionEvent event) throws IOException
  	{
  		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLoginPrincipal.fxml"));
      Parent telaParent = loader.load();
      Scene telaLoginParent = new Scene(telaParent);
      Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
      janela.setScene(telaLoginParent);
      janela.show();
  	}
  	
  	@FXML
  	public void entrarInicio(ActionEvent event) throws IOException
  	{
  		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipalFuncionarios.fxml"));
      Parent telaParent = loader.load();
      Scene telaLoginParent = new Scene(telaParent);
      Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
      janela.setScene(telaLoginParent);
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
  	public void removerUsuario(ActionEvent event) throws ElementoNaoExisteException {
  		Usuario usuario = meuSistema.recuperarUsuarioEspecifico(textFieldCpfUser.getText());
  		if (usuario instanceof Cliente) {
  			meuSistema.removerCliente(textFieldCpfUser.getText());
  		} else if (usuario instanceof Funcionario) {
  			meuSistema.excluirFuncionario(textFieldCpfUser.getText());
  		}
  		
  	}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			List<Ficha> trivial = meuSistema.listarFicha();
			for(Ficha i : trivial)
			{
				listFichas.getItems().add(i);
			}
			
			
		}
}
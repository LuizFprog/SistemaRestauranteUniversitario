package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;
import br.com.ru.negocio.models.ItemConsumivel;
import br.com.ru.negocio.models.ItemConsumivel.TipoCardapio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControllerDadosFuncionario implements Initializable{
	@FXML
	private Sistema meuSistema = Sistema.getInstancia();

    @FXML
    private ListView<Ficha> listFichas;

    
    
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

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			Cliente c = new Cliente("a","a","a","a","a",2.0);
			c.depositar(100);
			try {
				meuSistema.adicionarFicha(3.0, 11, c);
				
			} catch (ElementoJaExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SaldoInsuficienteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Ficha> trivial = meuSistema.listarFicha();
			for(Ficha i : trivial)
			{
				listFichas.getItems().add(i);
			}
			
			
		}
}
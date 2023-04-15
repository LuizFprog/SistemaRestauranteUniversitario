package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.negocio.Sistema;
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

public class TelaCardapioClienteController implements Initializable{
	@FXML
	private Sistema meuSistema = Sistema.getInstancia();

    @FXML
    private ListView<ItemConsumivel> listSobremesa;

    @FXML
    private ListView<ItemConsumivel> listSuco;

    @FXML
    private ListView<ItemConsumivel> listTrivial;

    @FXML
    private ListView<ItemConsumivel> listVegano;
    
    @FXML    
    public void listarItensTrivial() {
    	
    }
    
    @FXML    
    public void listarItensVegano() {
        meuSistema.cardapioVegano();
    }
    
    @FXML    
    public void listarItensSobremesa() {
        meuSistema.cardapioSobremesa();
    }
    
    @FXML    
    public void listarItensSuco() {
        meuSistema.cardapioSuco();
    }
    
    @FXML
  	public void irInicio(ActionEvent event) throws IOException
  	{
  		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipalCliente.fxml"));
      Parent telaParent = loader.load();
      Scene telaPrincipalParent = new Scene(telaParent);
      Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
      janela.setScene(telaPrincipalParent);
      janela.show();
  	}
  	
  	@FXML
  	public void irFichas(ActionEvent event) throws IOException
  	{
  		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaFichasCliente.fxml"));
      Parent telaParent = loader.load();
      Scene telaFichasParent = new Scene(telaParent);
      Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
      janela.setScene(telaFichasParent);
      janela.show();
  	}
  	
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

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			try {
				meuSistema.adicionarItemConsumivel("Nome", true, true, TipoCardapio.TRIVIAL, true);
				meuSistema.adicionarItemConsumivel("Nome2", true, true, TipoCardapio.VEGANO, true);
				meuSistema.adicionarItemConsumivel("Nome3", true, true, TipoCardapio.SOBREMESA, true);
				meuSistema.adicionarItemConsumivel("Nome4", true, true, TipoCardapio.SUCO, true);
			} catch (ElementoJaExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<ItemConsumivel> trivial = meuSistema.cardapioTrivial();
			for(ItemConsumivel i : trivial)
			{
				listTrivial.getItems().add(i);
			}
			
			List<ItemConsumivel> sobremesa = meuSistema.cardapioSobremesa();
			for(ItemConsumivel i : sobremesa)
			{
				listSobremesa.getItems().add(i);
			}
			
			List<ItemConsumivel> vegano = meuSistema.cardapioVegano();
			for(ItemConsumivel i : vegano)
			{
				listVegano.getItems().add(i);
			}
			
			List<ItemConsumivel> suco = meuSistema.cardapioSuco();
			for(ItemConsumivel i : suco)
			{
				listSuco.getItems().add(i);
			}
		}
}


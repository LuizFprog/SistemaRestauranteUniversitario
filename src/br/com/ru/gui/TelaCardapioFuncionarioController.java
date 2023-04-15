package br.com.ru.gui;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.ItemConsumivel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class TelaCardapioFuncionarioController implements Initializable{
	@FXML
	private Sistema meuSistema = Sistema.getInstancia();
	
	@FXML
	private Button adicionarItem;

	@FXML
	private ListView<ItemConsumivel> listaItem;

	@FXML
	private Button removerItem;

	@FXML
	private ChoiceBox<ItemConsumivel> nomeItem;
  
	@FXML
	public void adicionarItem(ActionEvent event) throws ElementoNaoExisteException
	{
		ItemConsumivel item = nomeItem.getValue();
		meuSistema.colocarNoCardapio(item);
		listaItem.getItems().add(item);  
	}
  
	@FXML
	public void removerItem(ActionEvent event) throws ElementoNaoExisteException
	{
		ItemConsumivel item = listaItem.getSelectionModel().getSelectedItem();
		listaItem.getItems().remove(item);
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
  	public void listarItens() {		
		List<ItemConsumivel> trivial = meuSistema.cardapio();
		for(ItemConsumivel i: trivial) {
			listaItem.getItems().add(i);
		}	
	}

  	@FXML
  	public void entrarTelaDados(ActionEvent event) throws Exception 
  	{
  		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaDadosFuncionario.fxml"));
  		Parent telaParent = loader.load();
  		Scene telaDadosParent = new Scene(telaParent);
  		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
  		janela.setScene(telaDadosParent);
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarItens();
		
		List<ItemConsumivel> itensTotais = meuSistema.verTodosItemConsumiveis();
		for(ItemConsumivel i : itensTotais)
		{
			if(i.isVisivel() == false)
			{
				nomeItem.getItems().add(i);
			}
		}
		
	}
}

package br.com.ru.gui;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.ItemConsumivel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

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
  	meuSistema.colocarNoCardapio(item);;
  }
  
  @FXML
  public void removerItem(ActionEvent event) throws ElementoNaoExisteException
  {
	ItemConsumivel item = listaItem.getSelectionModel().getSelectedItem();
  meuSistema.removerDoCardapio(item);;
  }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<ItemConsumivel> itens = meuSistema.cardapio();
		for(ItemConsumivel i : itens)
		{
			listaItem.getItems().add(i);
		}
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

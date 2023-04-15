package br.com.ru.gui;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaItemFuncionarioController implements Initializable{
	@FXML
	private Sistema meuSistema = Sistema.getInstancia();
	
	@FXML
    private Button buttonAtualizar;
	
	@FXML
	private Button buttonCardapio;
	
	@FXML
	private Button buttonInicio;
	
	@FXML
	private Button buttonDados;
	
	@FXML
	private Button buttonSair;
	
	@FXML
    private Button buttonRemoveItem;

    @FXML
    private ListView<ItemConsumivel> listItens;
    
    @FXML
    private ChoiceBox<TipoCardapio> choiceTipo;
    
    @FXML
    private ChoiceBox<TipoCardapio> choiceNovoItemTipo;
    
    @FXML
    private Button adicionar;
    
    @FXML
    private TextField textNome;
    
    @FXML
    private TextField textFieldNomeAtual;
    
    @FXML
    private TextField textFieldNovoNome;
    
    @FXML
    private TextField textFieldNomeItem;

    @FXML
    private CheckBox checkGluten;

    @FXML
    private CheckBox checkLactose;
    
    @FXML
    private CheckBox checkNovoGluten;

    @FXML
    private CheckBox checkNovoLactose;
    
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
  	public void listarItens() {
  		
		List<ItemConsumivel> trivial3 = meuSistema.verTodosItemConsumiveis();
		for(ItemConsumivel i: trivial3) {
			listItens.getItems().add(i);
		}	
	
  	}
  	
  	@FXML
  	public void criarItem(ActionEvent event) throws Exception {
  		  		
  		String nome = textNome.getText();
  		boolean gluten;
  		boolean lact;
  		if (checkGluten.isSelected()) {
  			gluten = true;
  		} else {
  			gluten = false;
  		}
  		
  		if (checkLactose.isSelected()) {
  			lact = true;
  		} else {
  			lact = false;
  		}
  		
  		TipoCardapio tipo = choiceTipo.getValue();  		
  		
  		meuSistema.adicionarItemConsumivel(nome, gluten, lact, tipo, lact);
  		listItens.getItems().add(meuSistema.recuperarItemConsumivel(nome));
  		
  		reloadItens(event);
  	}
  	
  	@FXML
	public void reloadItens(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaItemFuncionario.fxml"));
		Parent telaParent = loader.load();
		Scene telaItensParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaItensParent);
		janela.show();
	}
  	
  	@FXML
  	public void atualizarItem(ActionEvent event) throws Exception {
  		  		
  		String nomeAtual = textFieldNomeAtual.getText();
  		String novoNome = textFieldNovoNome.getText();  		
  		boolean gluten;
  		boolean lact;
  		if (checkNovoGluten.isSelected()) {
  			gluten = true;
  		} else {
  			gluten = false;
  		}
  		
  		if (checkNovoLactose.isSelected()) {
  			lact = true;
  		} else {
  			lact = false;
  		}  		
  		
  		TipoCardapio tipo = choiceNovoItemTipo.getValue();
  		
  		meuSistema.atualizarItemConsumivel(nomeAtual, novoNome, gluten, lact, tipo, lact);
  		listItens.getItems().add(meuSistema.recuperarItemConsumivel(novoNome));
  		
  		reloadItens(event);
  	}
  	
  	@FXML
  	public void removeItem(ActionEvent event) throws Exception {
  		listItens.getItems().remove(meuSistema.recuperarItemConsumivel(textFieldNomeItem.getText()));
  		meuSistema.removerItemConsumivel(textFieldNomeItem.getText());  		
  		
  		reloadItens(event);
  	}
  	
  	@FXML
    public void entrarTelaDados(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaDadosFuncionario.fxml"));
        Parent telaParent = loader.load();
        Scene telaDadosParent = new Scene(telaParent);
        Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        janela.setScene(telaDadosParent);
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

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			listarItens();
			
			choiceTipo.getItems().add(TipoCardapio.SOBREMESA);
			choiceTipo.getItems().add(TipoCardapio.TRIVIAL);
			choiceTipo.getItems().add(TipoCardapio.VEGANO);
			choiceTipo.getItems().add(TipoCardapio.SUCO);
			
			choiceNovoItemTipo.getItems().add(TipoCardapio.SOBREMESA);
			choiceNovoItemTipo.getItems().add(TipoCardapio.TRIVIAL);
			choiceNovoItemTipo.getItems().add(TipoCardapio.VEGANO);
			choiceNovoItemTipo.getItems().add(TipoCardapio.SUCO);
		}
}
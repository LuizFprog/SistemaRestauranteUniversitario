package br.com.ru.gui;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;

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
	private Button buttonCardapio;
	
	@FXML
	private Button buttonInicio;
	
	@FXML
	private Button buttonDados;
	
	@FXML
	private Button buttonSair;

    @FXML
    private ListView<ItemConsumivel> listItens;
    
    @FXML
    private ChoiceBox<TipoCardapio> choiceTipo;
    
    @FXML
    private Button adicionar;
    
    @FXML
    private TextField textNome;

    @FXML
    private CheckBox checkGluten;

    @FXML
    private CheckBox checkLactose;
    
    @FXML
    private boolean a;
    
    @FXML
    private boolean b;
    
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
  		
		List<ItemConsumivel> trivial = meuSistema.cardapio();
		
		int b = trivial.size();
		
		if(!(b<=0)) {
			ItemConsumivel trivial2 = meuSistema.cardapio().get(b-1);
			listItens.getItems().add(trivial2);
		} else {
			List<ItemConsumivel> trivial3 = meuSistema.cardapio();
			for(ItemConsumivel i: trivial3) {
				listItens.getItems().add(i);
			}
				
			
		}
		
		
			
	
  	}
  	
  	@FXML
  	public void glutenMarcado(ActionEvent event) {
  		
  		if(checkGluten.isSelected()) {
 			 b = true;
 		}
  	}
  	
  	@FXML
  	public void lactoseMarcado(ActionEvent event) {
  		
  		if(checkLactose.isSelected()) {
  			 a = true;
  		}
  		
  	}
  	
  	@FXML
  	public void criarItem() throws ElementoJaExisteException {
  		
  		String nome = textNome.getText();
  		boolean gluten = a;
  		boolean lact = b;
  		
  		TipoCardapio tipo = choiceTipo.getValue();
  		
  		meuSistema.adicionarItemConsumivel(nome, gluten, lact, tipo, lact);
  		listarItens();
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
//			listarItens();
			
//			choiceTipo.getItems().add(TipoCardapio.SOBREMESA);
//			choiceTipo.getItems().add(TipoCardapio.TRIVIAL);
//			choiceTipo.getItems().add(TipoCardapio.VEGANO);
//			choiceTipo.getItems().add(TipoCardapio.SUCO);
		}
}
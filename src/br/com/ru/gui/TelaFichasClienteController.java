package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaFichasClienteController implements Initializable{
	
	@FXML
	Sistema meuSistema = Sistema.getInstancia();
	
	@FXML
	private Label valorTotal;

	 @FXML
	 private ChoiceBox<ItemConsumivel> choiceboxCardapio;

    @FXML
    private Button buttonInicio;

    @FXML
    private Button buttonFicha;

    @FXML
    private Button buttonAdicionarRefe;

    @FXML
    private Button buttonRemoverRefe;

    @FXML
    private Button buttonFinalRefe;
    
    @FXML
    private Button buttonCardapio;
    
    @FXML
    private ChoiceBox<Integer> choiceFichas;
    
    @FXML
    private static TelaFichasClienteController instancia;
    
    @FXML
    public static TelaFichasClienteController getInstancia()
    {
    	if(instancia == null)
    	{
    		instancia = new TelaFichasClienteController();
    	}
    	return instancia;
    }
    
    @FXML
    private static Cliente cliente;
    
    public Cliente getCliente()
    {
    	return cliente;
    }
    
    public void setCliente(Cliente cliente)
    {
    	TelaFichasClienteController.cliente = cliente;
    }

    @FXML
    void irCardapio(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCardapioCliente.fxml"));
      Parent telaParent = loader.load();
      Scene telaCardapioParent = new Scene(telaParent);
      Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
      janela.setScene(telaCardapioParent);
      janela.show();
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
    public void adicionarRefeicao(ActionEvent event) {
    	
    	ItemConsumivel adicionadoItem = choiceboxCardapio.getValue();
    
    }
    
    @FXML
    public void acaoComprarFichas(ActionEvent event) throws ElementoJaExisteException, SaldoInsuficienteException, ElementoNaoExisteException
    {
    	Integer valor = choiceFichas.getValue();
    	meuSistema.adicionarFicha(3, 3 * valor, meuSistema.recuperarClienteEspecifico(cliente.getCpf()));
    }
    
    @FXML
    public void choiceBox(ActionEvent event)
    {
    	Double valor = choiceFichas.getValue() * 3.0;
    	valorTotal.setText("" + valor);
    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			for(int i = 1; i <= 10; i++)
			{
				choiceFichas.getItems().add(i);
			}
			choiceFichas.setOnAction(this::choiceBox);
			
			List<ItemConsumivel> itensTotais = meuSistema.verTodosItemConsumiveis();
			for(ItemConsumivel i : itensTotais)
			{
				if(i.isVisivel() != false)
				{
					choiceboxCardapio.getItems().add(i);
				}
			}
			
		}
		
		

}

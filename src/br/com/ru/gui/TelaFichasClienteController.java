package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;
import br.com.ru.negocio.models.Ficha.StatusFicha;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaFichasClienteController implements Initializable{
	
	@FXML
	Sistema meuSistema = Sistema.getInstancia();
	
	@FXML
	private Label valorTotal;

    @FXML
    private Button buttonInicio;

    @FXML
    private Button buttonFicha;

    @FXML
    private Button buttonFinalRefe;
    
    @FXML
    private Label compraFinalizada;
    
    @FXML
    private Button buttonCardapio;
    
    @FXML
    private ChoiceBox<Integer> choiceFichas;
    
  	@FXML
  	private PropertyValueFactory<Ficha, ?> PropertyValueFactory;
    
    @FXML
    private TableView<Ficha> listFichas;
    
    @FXML
    private TableColumn<Ficha, String> codigo;
    
    @FXML
    private TableColumn<Ficha, Cliente> nomeCliente;

    @FXML
    private TableColumn<Ficha, StatusFicha> statusFicha;
    
    @FXML
    private TableColumn<Ficha, LocalDate> dataEfetivacao;
    
    @FXML
  	ObservableList<Ficha> dados = FXCollections.observableArrayList();
    
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
	private void mostrarAlerta() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERROR COMPRA");
        alerta.setContentText("erro ao comprar ficha");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
        
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
	public void reload(ActionEvent event) throws IOException
	{
		
	FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaFichasCliente.fxml"));
    Parent telaParent = loader.load();
    Scene telaFichasParent = new Scene(telaParent);
    Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
    janela.setScene(telaFichasParent);
    janela.show();
	}
    
    @FXML
    public void acaoComprarFichas(ActionEvent event) throws Exception 
    {
    	//meuSistema.gerarRefeicoes();
    	Integer valor = choiceFichas.getValue();
    	try {
			meuSistema.adicionarFicha(3, 3 * valor, meuSistema.recuperarClienteEspecifico(cliente.getCpf()));
			reload(event);
		} catch (ElementoNaoExisteException | SaldoInsuficienteException | ElementoJaExisteException e) {
			mostrarAlerta();
			reload(event);
			//e.printStackTrace();
		}
    }
    
    @FXML
    public void gastarFicha(ActionEvent event) throws ElementoNaoExisteException
    {
    	Ficha itemRemovido = listFichas.getSelectionModel().getSelectedItem();
    	meuSistema.gastarFicha(itemRemovido);
    	compraFinalizada.setText("Compra Finalizada");
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
		
		Stream<Ficha> fichas;
		fichas = meuSistema.listarFicha().stream().filter(ficha -> ficha.getCliente() == cliente);
		List<Ficha> fichasClientes = fichas.toList();
		
		for (Ficha i : fichasClientes) {
			dados.add(i);
		}
		
		codigo.setCellValueFactory(new PropertyValueFactory<Ficha, String>("codigo"));
    //listFichas.getColumns().add(codigo);
    
    nomeCliente.setCellValueFactory(new PropertyValueFactory<Ficha, Cliente>("cliente"));
    //listFichas.getColumns().add(nomeCliente);
    
    statusFicha.setCellValueFactory(new PropertyValueFactory<Ficha, StatusFicha>("statusFicha"));
    //listFichas.getColumns().add(statusFicha);
    
    dataEfetivacao.setCellValueFactory(new PropertyValueFactory<Ficha, LocalDate>("dataEfetivacao"));
    //listFichas.getColumns().add(dataEfetivacao);
	
    listFichas.setItems(dados);
		
		
		
	}
	
		

}

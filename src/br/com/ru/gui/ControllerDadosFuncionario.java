package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;
import br.com.ru.negocio.models.Ficha.StatusFicha;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.Usuario;
import javafx.beans.binding.Bindings;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.transformation.FilteredList;


public class ControllerDadosFuncionario implements Initializable{	
	
	@FXML
	private Sistema meuSistema = Sistema.getInstancia();
	
	@FXML
	private PropertyValueFactory<Ficha, ?> propriedadeValorFabrica;
	
	@FXML
    private TableView<Ficha> listaFichas;
    
    @FXML
    private TableColumn<Ficha, String> codigo;
    
    @FXML
    private TableColumn<Ficha, Cliente> cliente;
    
    @FXML
    private TableColumn<Ficha, Double> preco;
    
    @FXML
    private TableColumn<Ficha, StatusFicha> statusFicha;
    
    @FXML
    private TableColumn<Ficha, LocalDate> dataEfetivacao;
    
    @FXML
    private TableColumn<Ficha, LocalDate> dataConsumo;
    
    @FXML
    private ListView<Cliente> listaClientes;
    
    @FXML
	ObservableList<Ficha> dados = FXCollections.observableArrayList();
    
    @FXML
    private DatePicker dataMax;

    @FXML
    private DatePicker dataMin;
    
    @FXML
    private Button botaoRemoveUser;
    
    @FXML
    private Button botaoFichaAtualizar;

    @FXML
    private Button botaoFichaDia;
    
    @FXML
    private TextField campoTextoCpfUsuario;
    
    @FXML
    private TextField novoPrecoFicha;
    
    @FXML
    private void mostrarAlerta() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO CADASTRAR");
        alerta.setContentText("Usuário não encontrado.");
        alerta.showAndWait();
    }
    
    @FXML
    public void atualizarDados(ActionEvent event) throws Exception {
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
  	public void trocarPreco(ActionEvent event) throws Exception {
  		try {
			Double valor = Double.valueOf(novoPrecoFicha.getText()).doubleValue();
			System.out.println(valor);
			meuSistema.atualizarPrecoFicha(valor);
						
			atualizarDados(event);
			
		} catch (NumberFormatException | ElementoNaoExisteException e) {
			mostrarAlerta();
			atualizarDados(event);			
		}
  	}
  	
  	@FXML
  	public void listarFichaPorPeriodo(ActionEvent event) {

  		FilteredList<Ficha> filteredItems = new FilteredList<>(dados);
  		
  		filteredItems.predicateProperty().bind(Bindings.createObjectBinding(() -> {
  			        LocalDate minDate = dataMin.getValue();
  			        LocalDate maxDate = dataMax.getValue();

  			        final LocalDate finalMin = minDate == null ? LocalDate.MIN : minDate;
  			        final LocalDate finalMax = maxDate == null ? LocalDate.MAX : maxDate;

  				      return ti -> ti.getDataEfetivacao() != null && !finalMin.isAfter(ti.getDataEfetivacao()) && !finalMax.isBefore(ti.getDataEfetivacao());

  				    },
  				    dataMin.valueProperty(),
  				    dataMax.valueProperty()));

  				listaFichas.setItems(filteredItems);
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
  	public void removerUsuario(ActionEvent event) throws Exception  {
  		Usuario usuario;
		try {
			if (!campoTextoCpfUsuario.getText().isEmpty()) {
				usuario = meuSistema.recuperarUsuarioEspecifico(campoTextoCpfUsuario.getText());	
				if (usuario instanceof Cliente) {
		  			meuSistema.removerCliente(campoTextoCpfUsuario.getText());
		  		} else if (usuario instanceof Funcionario) {
		  			meuSistema.excluirFuncionario(campoTextoCpfUsuario.getText());
		  		}
			}			
		} catch (ElementoNaoExisteException e) {
			mostrarAlerta();			
		}  		
  		
  	}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			try {
				if(meuSistema.retornarFicha() == null)
				{
					meuSistema.gerarFicha();
				}
			} catch (ElementoJaExisteException e) {
				
			}
									
			List<Ficha> fichas = meuSistema.listarFicha();
			for (Ficha i : fichas) {
				dados.add(i);
			}
			
			List<Cliente> clientes = meuSistema.listarTodosClientes();
			for (Cliente i : clientes) {
				listaClientes.getItems().add(i);
			}
			
			codigo.setCellValueFactory(new PropertyValueFactory<Ficha, String>("codigo"));
			if (!listaFichas.getColumns().contains(codigo)) {
				listaFichas.getColumns().add(codigo);
			}		    
		    
		    cliente.setCellValueFactory(new PropertyValueFactory<Ficha, Cliente>("cliente"));
		    if (!listaFichas.getColumns().contains(cliente)) {
				listaFichas.getColumns().add(cliente);
			}
		    
		    preco.setCellValueFactory(new PropertyValueFactory<Ficha, Double>("preco"));
				if (!listaFichas.getColumns().contains(preco)) {
					listaFichas.getColumns().add(preco);
				}	
		    		    
		    statusFicha.setCellValueFactory(new PropertyValueFactory<Ficha, StatusFicha>("statusFicha"));
		    if (!listaFichas.getColumns().contains(statusFicha)) {
				listaFichas.getColumns().add(statusFicha);
		    }
		    
		    dataEfetivacao.setCellValueFactory(new PropertyValueFactory<Ficha, LocalDate>("dataEfetivacao"));
		    if (!listaFichas.getColumns().contains(dataEfetivacao)) {
				listaFichas.getColumns().add(dataEfetivacao);
		    }
		    
		    dataConsumo.setCellValueFactory(new PropertyValueFactory<Ficha, LocalDate>("dataConsumo"));
		    if (!listaFichas.getColumns().contains(dataConsumo)) {
				listaFichas.getColumns().add(dataConsumo);
		    }
			
		    listaFichas.setItems(dados);
		}
}
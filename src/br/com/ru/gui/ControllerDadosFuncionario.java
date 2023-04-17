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
	private PropertyValueFactory<Ficha, ?> PropertyValueFactory;
	
	@FXML
    private TableView<Ficha> listFichas;
    
    @FXML
    private TableColumn<Ficha, String> codigo;
    
    @FXML
    private TableColumn<Ficha, Cliente> cliente;
    
    @FXML
    private TableColumn<Ficha, StatusFicha> statusFicha;
    
    @FXML
    private TableColumn<Ficha, LocalDate> dataEfetivacao;
    
    @FXML
    private TableColumn<Ficha, LocalDate> dataConsumo;
    
    @FXML
    private ListView<Cliente> listClientes;
    
    @FXML
	ObservableList<Ficha> dados = FXCollections.observableArrayList();
    
    @FXML
    private DatePicker dataMax;

    @FXML
    private DatePicker dataMin;
    
    @FXML
    private Button buttonRemoveUser;
    
    @FXML
    private Button buttonFichaAtualizar;
    
    @FXML
    private Button buttonFichaAno;

    @FXML
    private Button buttonFichaDia;

    @FXML
    private Button buttonFichaMes;
    
    @FXML
    private TextField textFieldCpfUser;
    
    @FXML
    private TextField novoPrecoFicha;
    
    @FXML
    private void mostrarAlerta() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO CADASTRAR");
        alerta.setContentText("Usuário não encontrado.");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }
    
    @FXML
    public void reloadDados(ActionEvent event) throws Exception {
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
						
			reloadDados(event);
			
		} catch (NumberFormatException | ElementoNaoExisteException e) {
			mostrarAlerta();
			reloadDados(event);			
		}
  	}
  	
  	@FXML
  	public void listarFichaPorPeriodo(ActionEvent event) {

  		FilteredList<Ficha> filteredItems = new FilteredList<>(dados);

  		// bind predicate based on datepicker choices
  		filteredItems.predicateProperty().bind(Bindings.createObjectBinding(() -> {
  			        LocalDate minDate = dataMin.getValue();
  			        LocalDate maxDate = dataMax.getValue();

  			        // get final values != null
  			        final LocalDate finalMin = minDate == null ? LocalDate.MIN : minDate;
  			        final LocalDate finalMax = maxDate == null ? LocalDate.MAX : maxDate;

  			        // values for openDate need to be in the interval [finalMin, finalMax]
  				      return ti -> ti.getDataEfetivacao() != null && !finalMin.isAfter(ti.getDataEfetivacao()) && !finalMax.isBefore(ti.getDataEfetivacao());

  				    },
  				    dataMin.valueProperty(),
  				    dataMax.valueProperty()));

  				listFichas.setItems(filteredItems);
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
			if (!textFieldCpfUser.getText().isEmpty()) {
				usuario = meuSistema.recuperarUsuarioEspecifico(textFieldCpfUser.getText());	
				if (usuario instanceof Cliente) {
		  			meuSistema.removerCliente(textFieldCpfUser.getText());
		  		} else if (usuario instanceof Funcionario) {
		  			meuSistema.excluirFuncionario(textFieldCpfUser.getText());
		  		}
			}			
		} catch (ElementoNaoExisteException e) {
			mostrarAlerta();			
		}  		
  		
  	}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			try {
				meuSistema.gerarFicha();
			} catch (ElementoJaExisteException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
									
			List<Ficha> fichas = meuSistema.listarFicha();
			for (Ficha i : fichas) {
				dados.add(i);
			}
			
			List<Cliente> clientes = meuSistema.listarTodosClientes();
			for (Cliente i : clientes) {
				listClientes.getItems().add(i);
			}
			
			codigo.setCellValueFactory(new PropertyValueFactory<Ficha, String>("codigo"));
			if (!listFichas.getColumns().contains(codigo)) {
				listFichas.getColumns().add(codigo);
			}		    
		    
		    cliente.setCellValueFactory(new PropertyValueFactory<Ficha, Cliente>("cliente"));
		    if (!listFichas.getColumns().contains(cliente)) {
				listFichas.getColumns().add(cliente);
			}
		    		    
		    statusFicha.setCellValueFactory(new PropertyValueFactory<Ficha, StatusFicha>("statusFicha"));
		    if (!listFichas.getColumns().contains(statusFicha)) {
				listFichas.getColumns().add(statusFicha);
		    }
		    
		    dataEfetivacao.setCellValueFactory(new PropertyValueFactory<Ficha, LocalDate>("dataEfetivacao"));
		    if (!listFichas.getColumns().contains(dataEfetivacao)) {
				listFichas.getColumns().add(dataEfetivacao);
		    }
		    
		    dataConsumo.setCellValueFactory(new PropertyValueFactory<Ficha, LocalDate>("dataConsumo"));
		    if (!listFichas.getColumns().contains(dataConsumo)) {
				listFichas.getColumns().add(dataConsumo);
		    }
			
		    listFichas.setItems(dados);
		}
}
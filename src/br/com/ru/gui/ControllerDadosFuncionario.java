package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Ficha;
import br.com.ru.negocio.models.Ficha.StatusFicha;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
	ObservableList<Ficha> dados = FXCollections.observableArrayList();
    
    @FXML
    private Button buttonRemoveUser;
    
    @FXML
    private Button buttonFichaAno;

    @FXML
    private Button buttonFichaDia;

    @FXML
    private Button buttonFichaMes;
    
    @FXML
    private TextField textFieldCpfUser;
    
    @FXML
    private ChoiceBox<Integer> choiceAno;

    @FXML
    private ChoiceBox<Integer> choiceDia;

    @FXML
    private ChoiceBox<Integer> choiceMes;
    
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
  	public void listarFichaPorDia(ActionEvent event) {
  		
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
  	public void removerUsuario(ActionEvent event) throws ElementoNaoExisteException {
  		Usuario usuario = meuSistema.recuperarUsuarioEspecifico(textFieldCpfUser.getText());
  		if (usuario instanceof Cliente) {
  			meuSistema.removerCliente(textFieldCpfUser.getText());
  		} else if (usuario instanceof Funcionario) {
  			meuSistema.excluirFuncionario(textFieldCpfUser.getText());
  		}
  		
  	}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			for(int i = 1; i <= 31; i++) {
				choiceDia.getItems().add(i);
			}
			
			for(int i = 1; i <= 12; i++) {
				choiceMes.getItems().add(i);
			}
			
			for(int i = 2014; i <= 2030; i++) {
				choiceAno.getItems().add(i);
			}
									
			List<Ficha> fichas = meuSistema.listarFicha();
			for (Ficha i : fichas) {
				dados.add(i);
			}
			
			codigo.setCellValueFactory(new PropertyValueFactory<Ficha, String>("codigo"));
		    listFichas.getColumns().add(codigo);
		    
		    cliente.setCellValueFactory(new PropertyValueFactory<Ficha, Cliente>("cliente"));
		    listFichas.getColumns().add(cliente);
		    
		    statusFicha.setCellValueFactory(new PropertyValueFactory<Ficha, StatusFicha>("statusFicha"));
		    listFichas.getColumns().add(statusFicha);
		    
		    dataEfetivacao.setCellValueFactory(new PropertyValueFactory<Ficha, LocalDate>("dataEfetivacao"));
		    listFichas.getColumns().add(dataEfetivacao);
		    
		    dataConsumo.setCellValueFactory(new PropertyValueFactory<Ficha, LocalDate>("dataConsumo"));
		    listFichas.getColumns().add(dataConsumo);
			
		    listFichas.setItems(dados);
		}
}
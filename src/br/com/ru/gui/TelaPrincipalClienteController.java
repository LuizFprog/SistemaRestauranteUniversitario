package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaPrincipalClienteController implements Initializable{

    @FXML
    private Button buttonCardapio;

    @FXML
    private Button buttonDepositar;

    @FXML
    private Button buttonFicha;
    
    @FXML
    private  static TelaPrincipalClienteController instancia;

    @FXML
    private Button buttonInicio;

    @FXML
	private Sistema meuSistema = Sistema.getInstancia();
    
    @FXML
    private TextField textCpfCliente;

    @FXML
    private TextField textLoginCliente;

    @FXML
    private TextField textNomeCliente;

    @FXML
    private TextField textSaldoAtual;

    @FXML
    private TextField textSenhaCliente;

    @FXML
    private TextField textValorDepositar;
    
    @FXML
    private static Cliente cliente;
    
    @FXML
    private VBox vBox;
    
    @FXML
    public static TelaPrincipalClienteController getInstancia()
	{
		if(instancia == null)
		{
			instancia = new TelaPrincipalClienteController();
		}
		return instancia;
	}
    
    @FXML
    private TelaFichasClienteController clienteAtual = TelaFichasClienteController.getInstancia();

    @FXML
	public Cliente getCliente() {
		return cliente;
	}

    
	public void setCliente(Cliente cliente) {
		TelaPrincipalClienteController.cliente = cliente;
	}	
    
	@FXML
	public void acaoEntrar(ActionEvent event) throws Exception {
		
		System.out.println(cliente.toString());
		System.out.println("A");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textCpfCliente.setText(cliente.getCpf());
		textLoginCliente.setText(cliente.getLogin());
		textNomeCliente.setText(cliente.getPrimeiroNome() + " " + cliente.getUltimoNome());
		textSenhaCliente.setText(cliente.getSenha());
		textSaldoAtual.setText(String.valueOf(cliente.getSaldo()));
		
	}
	
	@FXML
	public void irCardapio(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCardapioCliente.fxml"));
    Parent telaParent = loader.load();
    Scene telaCardapioParent = new Scene(telaParent);
    Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
    janela.setScene(telaCardapioParent);
    janela.show();
	}
	
	@FXML
	public void irFichas(ActionEvent event) throws IOException
	{
		clienteAtual.setCliente(cliente);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaFichasCliente.fxml"));
    Parent telaParent = loader.load();
    Scene telaFichasParent = new Scene(telaParent);
    Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
    janela.setScene(telaFichasParent);
    janela.show();
	}
	
	@FXML
	public void acaoDepositar(ActionEvent event) throws Exception {
		
		Double valor = Double.valueOf(textValorDepositar.getText()).doubleValue();
		meuSistema.depositar(valor, cliente.getCpf());
		
		String novoSaldo = String.valueOf(cliente.getSaldo());
		
		textSaldoAtual.setText(novoSaldo);
	}
    
}

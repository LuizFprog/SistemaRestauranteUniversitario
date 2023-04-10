package br.com.ru.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Funcionario;
import br.com.ru.negocio.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    public static TelaPrincipalClienteController getInstancia()
	{
		if(instancia == null)
		{
			instancia = new TelaPrincipalClienteController();
		}
		return instancia;
	}

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
	public void acaoDepositar(ActionEvent event) throws Exception {
		
		Double valor = Double.valueOf(textValorDepositar.getText()).doubleValue();
		meuSistema.depositar(valor, cliente.getCpf());
		
		String novoSaldo = String.valueOf(cliente.getSaldo());
		
		textSaldoAtual.setText(novoSaldo);
	}
    
}

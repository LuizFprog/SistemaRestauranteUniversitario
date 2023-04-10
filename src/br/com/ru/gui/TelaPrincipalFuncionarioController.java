package br.com.ru.gui;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.ru.negocio.Sistema;
import br.com.ru.negocio.models.Cliente;
import br.com.ru.negocio.models.Funcionario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TelaPrincipalFuncionarioController  implements Initializable{

    @FXML
    private Button buttonCardapio;
    
    @FXML
	private Sistema meuSistema = Sistema.getInstancia();
    
    @FXML
    private  static TelaPrincipalFuncionarioController instancia;

    @FXML
    private Button buttonDados;

    @FXML
    private Button buttonInicio;

    @FXML
    private Button buttonItens;

    @FXML
    private TextField textCpfFunc;

    @FXML
    private TextField textIdFunc;

    @FXML
    private TextField textLoginFunc;

    @FXML
    private TextField textNomeFunc;

    @FXML
    private TextField textSenhaFunc;
    
    @FXML
    private static Funcionario funcionario;

	@FXML
    public static TelaPrincipalFuncionarioController getInstancia()
	{
		if(instancia == null)
		{
			instancia = new TelaPrincipalFuncionarioController();
		}
		return instancia;
	}
	
	public static Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		TelaPrincipalFuncionarioController.funcionario = funcionario;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textCpfFunc.setText(funcionario.getCpf());
		textLoginFunc.setText(funcionario.getLogin());
		textNomeFunc.setText(funcionario.getPrimeiroNome() + " " + funcionario.getUltimoNome());
		textSenhaFunc.setText(funcionario.getSenha());
		textIdFunc.setText(funcionario.getId());
		
	}

	
	
	
}

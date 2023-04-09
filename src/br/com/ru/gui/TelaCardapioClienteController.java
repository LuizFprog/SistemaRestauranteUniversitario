package br.com.ru.gui;

import br.com.ru.negocio.Sistema;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TelaCardapioClienteController {
	
	private Sistema meuSistema = Sistema.getInstancia();

    @FXML
    private ListView<?> listSobremesa;

    @FXML
    private ListView<?> listSuco;

    @FXML
    private ListView<?> listTrivial;

    @FXML
    private ListView<?> listVegano;
    
    @FXML    
    public void listarItensTrivial() {
        meuSistema.cardapioTrivial();
    }
    
    @FXML    
    public void listarItensVegano() {
        meuSistema.cardapioVegano();
    }
    
    @FXML    
    public void listarItensSobremesa() {
        meuSistema.cardapioSobremesa();
    }
    
    @FXML    
    public void listarItensSuco() {
        meuSistema.cardapioSuco();
    }
}


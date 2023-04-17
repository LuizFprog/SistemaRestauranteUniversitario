package br.com.ru.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaItemFuncionarioController implements Initializable {
	@FXML
	private Sistema meuSistema = Sistema.getInstancia();

	@FXML
	private Button botaoAtualizar;

	@FXML
	private Button botaoCardapio;

	@FXML
	private Button botaoInicio;

	@FXML
	private Button botaoDados;

	@FXML
	private Button botaoSair;

	@FXML
	private Button botaoRemoveItem;

	@FXML
	private ListView<ItemConsumivel> listaItens;

	@FXML
	private ChoiceBox<TipoCardapio> escolheTipo;

	@FXML
	private ChoiceBox<TipoCardapio> escolheNovoItemTipo;

	@FXML
	private Button adicionar;

	@FXML
	private TextField campoTextoNome;

	@FXML
	private TextField campoTextoNomeAtual;

	@FXML
	private TextField campoTextoNovoNome;

	@FXML
	private TextField campoTextoNomeItem;

	@FXML
	private CheckBox possuiGluten;

	@FXML
	private CheckBox possuiLactose;

	@FXML
	private CheckBox novoPossuiGluten;

	@FXML
	private CheckBox novoPossuiLactose;

	@FXML
	public void irInicio(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrincipalCliente.fxml"));
		Parent telaParent = loader.load();
		Scene telaPrincipalParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaPrincipalParent);
		janela.show();
	}

	@FXML
	public void irFichas(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaFichasCliente.fxml"));
		Parent telaParent = loader.load();
		Scene telaFichasParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaFichasParent);
		janela.show();
	}

	@FXML
	public void listarItens() {

		List<ItemConsumivel> trivial3 = meuSistema.verTodosItemConsumiveis();
		for (ItemConsumivel i : trivial3) {
			listaItens.getItems().add(i);
		}

	}

	@FXML
	public void criarItem(ActionEvent event) throws Exception {

		String nome = campoTextoNome.getText();
		boolean gluten;
		boolean lact;
		if (possuiGluten.isSelected()) {
			gluten = true;
		} else {
			gluten = false;
		}

		if (possuiLactose.isSelected()) {
			lact = true;
		} else {
			lact = false;
		}

		TipoCardapio tipo = escolheTipo.getValue();
		try {
			if (!nome.isEmpty() && tipo != null) {
				meuSistema.adicionarItemConsumivel(nome, gluten, lact, tipo, false);
				listaItens.getItems().add(meuSistema.recuperarItemConsumivel(nome));
				recarregarItens(event);
			}
		} catch (ElementoJaExisteException e) {
			mostrarAlertaJaExiste();
			recarregarItens(event);
		}

	}

	@FXML
	private void mostrarAlertaNaoExiste() {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("ERROR");
		alerta.setHeaderText("ERRO AO PROCURAR");
		alerta.setContentText("O objeto mencionado não existe.");
		alerta.showAndWait();
	}

	@FXML
	private void mostrarAlertaJaExiste() {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("ERROR");
		alerta.setHeaderText("ERRO AO ADICIONAR");
		alerta.setContentText("O objeto mencionado já existe.");
		alerta.showAndWait();
	}

	@FXML
	public void recarregarItens(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaItemFuncionario.fxml"));
		Parent telaParent = loader.load();
		Scene telaItensParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaItensParent);
		janela.show();
	}

	@FXML
	public void atualizarItem(ActionEvent event) throws Exception {

		String nomeAtual = campoTextoNomeAtual.getText();
		String novoNome = campoTextoNovoNome.getText();
		boolean gluten;
		boolean lact;
		if (novoPossuiGluten.isSelected()) {
			gluten = true;
		} else {
			gluten = false;
		}

		if (novoPossuiLactose.isSelected()) {
			lact = true;
		} else {
			lact = false;
		}

		TipoCardapio tipo = escolheNovoItemTipo.getValue();

		try {
			if (!nomeAtual.isEmpty() && !novoNome.isEmpty() && tipo != null) {
				meuSistema.atualizarItemConsumivel(nomeAtual, novoNome, gluten, lact, tipo, false);
				listaItens.getItems().add(meuSistema.recuperarItemConsumivel(novoNome));
				recarregarItens(event);
			}
		} catch (ElementoNaoExisteException e) {
			mostrarAlertaNaoExiste();
		} catch (ElementoJaExisteException e) {
			mostrarAlertaJaExiste();
		}

	}

	@FXML
	public void removeItem(ActionEvent event) throws Exception {
		try {
			if (!campoTextoNomeItem.getText().isEmpty()) {
				listaItens.getItems().remove(meuSistema.recuperarItemConsumivel(campoTextoNomeItem.getText()));
				meuSistema.removerItemConsumivel(campoTextoNomeItem.getText());
				recarregarItens(event);
			}
		} catch (ElementoNaoExisteException e) {
			mostrarAlertaNaoExiste();
		}

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
	public void sairLogin(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLoginPrincipal.fxml"));
		Parent telaParent = loader.load();
		Scene telaLoginParent = new Scene(telaParent);
		Stage janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
		janela.setScene(telaLoginParent);
		janela.show();
	}

	@FXML
	public void entrarInicio(ActionEvent event) throws IOException {
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
		listarItens();

		escolheTipo.getItems().add(TipoCardapio.SOBREMESA);
		escolheTipo.getItems().add(TipoCardapio.TRIVIAL);
		escolheTipo.getItems().add(TipoCardapio.VEGANO);
		escolheTipo.getItems().add(TipoCardapio.SUCO);

		escolheNovoItemTipo.getItems().add(TipoCardapio.SOBREMESA);
		escolheNovoItemTipo.getItems().add(TipoCardapio.TRIVIAL);
		escolheNovoItemTipo.getItems().add(TipoCardapio.VEGANO);
		escolheNovoItemTipo.getItems().add(TipoCardapio.SUCO);
	}
}
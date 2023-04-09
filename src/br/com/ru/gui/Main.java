package br.com.ru.gui;

import br.com.ru.exceptions.ElementoJaExisteException;
import br.com.ru.exceptions.ElementoNaoExisteException;
import br.com.ru.exceptions.SaldoInsuficienteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TelaLoginPrincipal.fxml"));
        Scene scene = new Scene(root, 800, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws ElementoJaExisteException, ElementoNaoExisteException, SaldoInsuficienteException {
        launch(args);
    }
}

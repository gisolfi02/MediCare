package com.example.medicare;

import DataTier.MediCare.Utente.Utente;
import LogicTier.MediCare.Login.LoginLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {
    @FXML
    private TextField fieldEmail;
    @FXML
    private PasswordField fieldPassword;
    @FXML
    private Label error;



    private Scene scene;
    private Stage stage;
    private FXMLLoader fxmlLoader;



    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        String email = fieldEmail.getText();
        String password = fieldPassword.getText();

        LoginLogic loginLogic = new LoginLogic();
        Utente u = loginLogic.doLogin(email, password);

        if (u == null) {
            error.setText("Email o password errati");
            throw new RuntimeException();
        }

        //quest righe di codice servono per cambiare la pagina da visualizzare, so sempre uguali
        fxmlLoader = new FXMLLoader(Main.class.getResource("HomePage.fxml"));
        Parent root = fxmlLoader.load();
        HomePageController homePageController = fxmlLoader.getController();
        homePageController.setUtente(u);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void onRegistratiButtonClick(ActionEvent event) throws IOException{
        fxmlLoader = new FXMLLoader(Main.class.getResource("register-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}

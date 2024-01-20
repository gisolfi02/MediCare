package com.example.medicare;

import DataTier.MediCare.Utente.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AreaPrenotazioneController {
    private Scene scene;
    private Stage stage;
    private FXMLLoader fxmlLoader;


    static Utente utente;

    @FXML
    protected void initialize() {
    }

    @FXML
    protected void goHome(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(Main.class.getResource("HomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void goToProfile(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(Main.class.getResource("user.fxml"));
        Parent root = fxmlLoader.load();
        UserController userController = fxmlLoader.getController();
        userController.setUtente(utente);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void goToNuovaPrenotazione(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(Main.class.getResource("nuovaPrenotazione-view.fxml"));
        Parent root = fxmlLoader.load();
        NuovaPrenotazioneController nuovaPrenotazioneController = fxmlLoader.getController();
        nuovaPrenotazioneController.setUtente(utente);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void goToStoricoPrenotazione(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(Main.class.getResource("storicoPrenotazione-view.fxml"));
        Parent root = fxmlLoader.load();
        StoricoPrenotazioniController storicoPrenotazioniController = fxmlLoader.getController();
        storicoPrenotazioniController.setUtente(utente);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    protected void setUtente(Utente utente){
        AreaPrenotazioneController.utente = utente;
    }
}
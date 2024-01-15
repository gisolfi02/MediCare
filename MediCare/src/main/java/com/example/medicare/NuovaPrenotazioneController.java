package com.example.medicare;

import DataTier.MediCare.Utente.Utente;
import LogicTier.MediCare.Prenotazione.Prenotazione;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NuovaPrenotazioneController implements Initializable {
    private Prenotazione prenotazione = new Prenotazione();
    @FXML
    private ChoiceBox<String> repartiBox;
    @FXML
    private ChoiceBox<String> comuniBox;
    @FXML
    private ChoiceBox<String> ospedaliBox;
    @FXML
    private ChoiceBox<String> medicoBox;

    @FXML
    private Label ospedaliLabel;
    @FXML
    private Label repartiLabel;
    @FXML
    private Label medicoLabel;

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

    protected void setUtente(Utente utente){
        NuovaPrenotazioneController.utente = utente;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ArrayList<String> comuni = prenotazione.getComuni();
        comuniBox.getItems().addAll(comuni);
        comuniBox.setOnAction(this::mostraOspedali);

    }

    private void mostraOspedali(ActionEvent event){
        ArrayList<String> ospedali = prenotazione.getOspedali(comuniBox.getValue());
        ospedaliBox.getItems().addAll(ospedali);
        ospedaliLabel.setVisible(true);
        ospedaliBox.setVisible(true);
        ospedaliBox.setOnAction(this::mostraReparti);
    }

    private void mostraReparti(ActionEvent event){
        ArrayList<String> reparti = prenotazione.getReparti(ospedaliBox.getValue());
        repartiBox.getItems().addAll(reparti);
        repartiLabel.setVisible(true);
        repartiBox.setVisible(true);
        repartiBox.setOnAction(this::mostraMedici);
    }

    private void mostraMedici(ActionEvent event) {
        ArrayList<String> medici = prenotazione.getMedici(repartiBox.getValue(),ospedaliBox.getValue());
        medicoBox.getItems().addAll(medici);
        medicoLabel.setVisible(true);
        medicoBox.setVisible(true);
    }

}
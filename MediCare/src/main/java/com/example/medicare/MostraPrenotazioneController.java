package com.example.medicare;

import DataTier.MediCare.Medico.Medico;
import DataTier.MediCare.Ospedale.Ospedale;
import DataTier.MediCare.Prenotazione.Prenotazione;
import DataTier.MediCare.Utente.Utente;
import LogicTier.MediCare.Prenotazione.PrenotazioneLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MostraPrenotazioneController {
    private Scene scene;
    private Stage stage;
    private FXMLLoader fxmlLoader;


    @FXML
    private Label prenotazioneLabel;
    @FXML
    private Label nomeLabel;
    @FXML
    private Label cognomeLabel;
    @FXML
    private Label cfLabel;
    @FXML
    private Label dataLabel;
    @FXML
    private Label oraLabel;
    @FXML
    private Label medicoLabel;
    @FXML
    private Label repartoLabel;
    @FXML
    private Label ospedaleLabel;
    @FXML
    private Label comuneLabel;

    private Prenotazione prenotazione;
    static Utente utente;


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
        MostraPrenotazioneController.utente = utente;
    }
    protected void setPrenotazione(Prenotazione p){
        prenotazione = p;
        String temp;
        temp = prenotazioneLabel.getText() + prenotazione.getCodice();
        prenotazioneLabel.setText(temp);
        temp = nomeLabel.getText() + " " + prenotazione.getNome();
        nomeLabel.setText(temp);
        temp = cognomeLabel.getText() + " " + prenotazione.getCognome();
        cognomeLabel.setText(temp);
        temp = cfLabel.getText() + " " + prenotazione.getCf();
        cfLabel.setText(temp);
        temp = dataLabel.getText() + " " + prenotazione.getData();
        dataLabel.setText(temp);
        temp = oraLabel.getText() + " " + prenotazione.getOra();
        oraLabel.setText(temp);


        PrenotazioneLogic prenotazioneLogic = new PrenotazioneLogic();
        Medico medico = prenotazioneLogic.getMedico(prenotazione.getIdMedico());
        temp = medicoLabel.getText() + " Dott. " + medico.getNome() + " " + medico.getCognome();
        medicoLabel.setText(temp);
        temp = repartoLabel.getText() + " " + medico.getNomeReparto();
        repartoLabel.setText(temp);

        Ospedale ospedale = prenotazioneLogic.getOspedale(prenotazione.getIdOspedale());
        temp = ospedaleLabel.getText() + " " + ospedale.getNome();
        ospedaleLabel.setText(temp);
        temp = comuneLabel.getText() + " " + ospedale.getPaese();
        comuneLabel.setText(temp);
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
}
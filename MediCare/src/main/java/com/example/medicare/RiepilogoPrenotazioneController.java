package com.example.medicare;

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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La seguente classe gestisce l'iterfaccia del riepilodo della prenotazione
 */
public class RiepilogoPrenotazioneController {


    @FXML
    private Pane riepilogoPane;
    @FXML
    private Label pazienteLabel;
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
    @FXML
    private Label resultLabel;

    private Scene scene;
    private Stage stage;
    private FXMLLoader fxmlLoader;


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
        HomePageController.utente = utente;
    }

    protected void riepilogo(Prenotazione prenotazione, String medico, String reparto, String ospedale, String comune){
        this.prenotazione = prenotazione;

        String paziente = pazienteLabel.getText() + prenotazione.getNome() + " " + prenotazione.getCognome();
        pazienteLabel.setText(paziente);
        String cf = cfLabel.getText() + prenotazione.getCf();
        cfLabel.setText(cf);
        String data = dataLabel.getText() + prenotazione.getData().toString();
        dataLabel.setText(data);
        String ora = oraLabel.getText() + prenotazione.getOra();
        oraLabel.setText(ora);
        String nomeMedico = medicoLabel.getText() + medico.split("-")[0];
        medicoLabel.setText(nomeMedico);
        String nomeReparto = repartoLabel.getText() + reparto;
        repartoLabel.setText(nomeReparto);
        String nomeOspedale = ospedaleLabel.getText() + ospedale.split("-")[0];
        ospedaleLabel.setText(nomeOspedale);
        String nomeComune = comuneLabel.getText() + comune;
        comuneLabel.setText(nomeComune);
    }

    @FXML
    protected void salva(ActionEvent event){
        PrenotazioneLogic prenotazioneLogic = new PrenotazioneLogic();
        riepilogoPane.setVisible(false);
        if(!prenotazioneLogic.salvaPrenotazione(prenotazione)){
            resultLabel.setText("La prenotazione non è andata a buon fine, riprova.");
        }else{
            resultLabel.setText("Prenotazione effettata con successo.");
        }
    }
}
package com.example.medicare;

import DataTier.MediCare.Medico.Medico;
import DataTier.MediCare.Ospedale.Ospedale;
import DataTier.MediCare.Prenotazione.Prenotazione;
import DataTier.MediCare.Utente.Utente;
import LogicTier.MediCare.Prenotazione.PrenotazioneLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La seguente classe gestisce l'interfaccia nella quale si visualizza una prenotazione
 */
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
    @FXML
    private Label salvaLabel;
    @FXML
    private Pane confermaPane;
    @FXML
    private Pane prenotazionePane;
    @FXML
    private Pane operazioniPane;
    @FXML
    private Button modificaButton;
    @FXML
    private Button eliminaButton;
    @FXML
    private Button salvaButton;
    @FXML
    private DatePicker dataPicker;
    @FXML
    private ChoiceBox<String> oraBox;


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

        if(prenotazione.getData().isAfter(LocalDate.now())){
            operazioniPane.setVisible(true);
        }
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

    @FXML
    protected void elimina(ActionEvent event) throws IOException {
        prenotazionePane.setVisible(false);
        operazioniPane.setVisible(false);
        confermaPane.setVisible(true);
    }
    @FXML
    protected void conferma(ActionEvent event) throws IOException {
        PrenotazioneLogic prenotazioneLogic = new PrenotazioneLogic();
        prenotazioneLogic.eliminaPrenotazione(prenotazione.getCodice());

        fxmlLoader = new FXMLLoader(Main.class.getResource("storicoPrenotazione-view.fxml"));
        Parent root = fxmlLoader.load();
        StoricoPrenotazioniController storicoPrenotazioniController = fxmlLoader.getController();
        storicoPrenotazioniController.setUtente(utente);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void modifica(ActionEvent event) throws IOException {
        modificaButton.setVisible(false);
        eliminaButton.setVisible(false);
        salvaButton.setVisible(true);

        dataLabel.setText("Data Prenotazione: ");
        oraLabel.setText("Ora Prenotazione: ");
        dataPicker.setVisible(true);
        oraBox.setVisible(true);
    }

    @FXML
    protected void salva(ActionEvent event) throws IOException {
        PrenotazioneLogic prenotazioneLogic = new PrenotazioneLogic();
        int result = prenotazioneLogic.salvaModifiche(prenotazione.getCodice(),dataPicker.getValue(),oraBox.getValue());
        switch(result){
            case 1:{
                salvaLabel.setText("Data non valida");
                throw new RuntimeException();
            }
            case 2:{
                salvaLabel.setText("Ora non valida");
                throw new RuntimeException();
            }
            case 0:{
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
    }

    @FXML
    protected void mostraOra(MouseEvent event){
        if(dataPicker.getValue().isBefore(LocalDate.now())){
            salvaLabel.setText("Data non valida");
            throw new RuntimeException();
        }else {
            salvaLabel.setText("");
            PrenotazioneLogic prenotazioneLogic = new PrenotazioneLogic();
            ArrayList<String> ore = prenotazioneLogic.getOre(dataPicker.getValue(), "x-" + prenotazione.getIdMedico());
            ObservableList<String> oreDisp = FXCollections.observableArrayList(ore);
            oraBox.setItems(oreDisp);
        }
    }
}
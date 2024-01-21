package com.example.medicare;

import DataTier.MediCare.Prenotazione.Prenotazione;
import DataTier.MediCare.Utente.Utente;
import LogicTier.MediCare.Prenotazione.PrenotazioneLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * La seguente classe gestice l'interfaccia della nuova prenotazione
 */
public class NuovaPrenotazioneController implements Initializable {
    private PrenotazioneLogic prenotazioneLogic = new PrenotazioneLogic();


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



    @FXML
    private Pane formPrenotazione;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField cognomeField;
    @FXML
    private TextField cfField;
    @FXML
    private DatePicker dataPicker;
    @FXML
    private ChoiceBox<String> oraBox;
    @FXML
    private Label errore;


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
        ArrayList<String> comuni = prenotazioneLogic.getComuni();
        comuniBox.getItems().addAll(comuni);
        comuniBox.setOnAction(this::mostraOspedali);

    }

    private void mostraOspedali(ActionEvent event){
        ArrayList<String> ospedali = prenotazioneLogic.getOspedali(comuniBox.getValue());
        ObservableList<String> listaOspedali = FXCollections.observableArrayList(ospedali);
        ospedaliBox.getItems().removeAll();
        ospedaliBox.setItems(listaOspedali);
        ospedaliLabel.setVisible(true);
        ospedaliBox.setVisible(true);
        ospedaliBox.setOnAction(this::mostraReparti);
    }

    private void mostraReparti(ActionEvent event){
        ArrayList<String> reparti = prenotazioneLogic.getReparti(ospedaliBox.getValue());
        ObservableList<String> listaReparti = FXCollections.observableArrayList(reparti);
        repartiBox.setItems(listaReparti);
        repartiLabel.setVisible(true);
        repartiBox.setVisible(true);
        repartiBox.setOnAction(this::mostraMedici);
    }

    private void mostraMedici(ActionEvent event) {
        ArrayList<String> medici = prenotazioneLogic.getMedici(repartiBox.getValue(),ospedaliBox.getValue());
        ObservableList<String> listaMedici = FXCollections.observableArrayList(medici);
        medicoBox.setItems(listaMedici);
        medicoLabel.setVisible(true);
        medicoBox.setVisible(true);
        medicoBox.setOnAction(this::mostraFrom);
    }

    private void mostraFrom(ActionEvent event) {
        formPrenotazione.setVisible(true);
    }

    @FXML
    private void prenota(ActionEvent event) throws IOException {
        String nome = nomeField.getText();
        String cognome = cognomeField.getText();
        String cf = cfField.getText();
        LocalDate data = dataPicker.getValue();
        String ora = oraBox.getValue();

        int result = prenotazioneLogic.doPrenotazione(nome, cognome, cf, data, ora, utente.getEmail(), medicoBox.getValue(), ospedaliBox.getValue());
        switch (result) {
            case 1: {
                errore.setText("Nome non valido");
                throw new RuntimeException();
            }
            case 2:{
                errore.setText("Cognome non valido");
                throw new RuntimeException();
            }
            case 3: {
                errore.setText("Codice Fiscale non valido");
                throw new RuntimeException();
            }
            case 4: {
                errore.setText("Data non valida");
                throw new RuntimeException();
            }
            case 5: {
                errore.setText("Ora non valida");
                throw new RuntimeException();
            }
        }
        Prenotazione prenotazione = prenotazioneLogic.getPrenotazione();

        fxmlLoader = new FXMLLoader(Main.class.getResource("riepilogoPrenotazione-view.fxml"));
        Parent root = fxmlLoader.load();
        RiepilogoPrenotazioneController riepilogoPrenotazioneController = fxmlLoader.getController();
        riepilogoPrenotazioneController.setUtente(utente);
        riepilogoPrenotazioneController.riepilogo(prenotazione,medicoBox.getValue(),repartiBox.getValue(),ospedaliBox.getValue(),comuniBox.getValue());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void upperCase(KeyEvent event){
        cfField.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));
    }

    @FXML
    protected void mostraOra(MouseEvent event){
        ArrayList<String> ore = prenotazioneLogic.getOre(dataPicker.getValue(),medicoBox.getValue());
        ObservableList oreDisp = FXCollections.observableArrayList(ore);
        oraBox.setItems(oreDisp);
    }
}
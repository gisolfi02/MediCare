package com.example.medicare;


import DataTier.MediCare.Utente.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatbotController {
    @FXML
    private Button home;
    @FXML
    private Button Profilo;


    private Scene scene;
    private Stage stage;
    private FXMLLoader fxmlLoader;

    static Utente utente;

    @FXML
    protected void initialize() {
        // Aggiungi i tooltip programmaticamente se necessario
        Tooltip homeTooltip = new Tooltip("Clicca per tornare alla Home");
        Tooltip.install(home, homeTooltip);

        Tooltip profiloTooltip = new Tooltip("Visualizza il tuo profilo");
        Tooltip.install(Profilo, profiloTooltip);
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
        this.utente = utente;
    }
}
package com.example.medicare;

import DataTier.MediCare.Utente.Utente;
import LogicTier.MediCare.CercaOspedali.CercaOspedaliLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


/**
 * La seguente classe gestisce l'iterfaccia dell'area cerca ospedali
 */
public class CercaOspedaliController {

    @FXML
    private TextField ricercaField;
    @FXML
    private TextArea ospedaliArea;

    private Scene scene;
    private Stage stage;
    private FXMLLoader fxmlLoader;
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
        CercaOspedaliController.utente = utente;
    }

    @FXML
    protected void cerca(ActionEvent event){
        ospedaliArea.clear();
        String ricerca = ricercaField.getText();
        CercaOspedaliLogic cercaOspedaliLogic = new CercaOspedaliLogic();
        ArrayList<String> ospedali = cercaOspedaliLogic.cercaOspedali(ricerca);
        if (ospedali == null){
            ospedaliArea.appendText("Il campo località è vuoto, inserire una località");
            throw new RuntimeException();
        }
        if (ospedali.isEmpty()){
            ospedaliArea.appendText("Località non valida, riprovare");
            throw new RuntimeException();
        }
        for (String o : ospedali){
            ospedaliArea.appendText(o +"\n");
        }
    }
}

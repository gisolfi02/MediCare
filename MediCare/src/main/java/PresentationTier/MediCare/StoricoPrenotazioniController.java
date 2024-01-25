package PresentationTier.MediCare;

import DataTier.MediCare.Prenotazione.Prenotazione;
import DataTier.MediCare.Utente.Utente;
import LogicTier.MediCare.Prenotazione.PrenotazioneLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * La seguente classe gestisce l'iterfaccia che mostra lo storico delle prenotazioni
 */
public class StoricoPrenotazioniController implements Initializable {

    @FXML
    private VBox container;


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        PrenotazioneLogic prenotazioneLogic = new PrenotazioneLogic();
        ArrayList<Prenotazione> prenotazioni = prenotazioneLogic.getPrenotazioni(AreaPrenotazioneController.utente);
        ArrayList<Button> buttons = new ArrayList<>();
        for (Prenotazione p : prenotazioni){
            String prenotazione = "Prenotazione N." + p.getCodice() +"\n" + p.getData().toString() + " | " + p.getOra();
            Button button = new Button(prenotazione);
            button.getStyleClass().add("prenotazione");
            button.setOnAction(event -> {
                try {
                    fxmlLoader = new FXMLLoader(Main.class.getResource("mostraPrenotazione-view.fxml"));
                    Parent root = fxmlLoader.load();
                    MostraPrenotazioneController mostraPrenotazioneController = fxmlLoader.getController();
                    mostraPrenotazioneController.setUtente(AreaPrenotazioneController.utente);
                    mostraPrenotazioneController.setPrenotazione(p);

                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            buttons.add(button);
        }
        container.getChildren().clear();
        container.getChildren().addAll(buttons);
    }

    protected void setUtente(Utente utente){
        StoricoPrenotazioniController.utente = utente;
    }
}
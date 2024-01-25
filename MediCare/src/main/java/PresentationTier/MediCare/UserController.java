package PresentationTier.MediCare;

import DataTier.MediCare.Utente.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La seguente classe gestisce l'iterfaccia dell'area personale dell'utente
 */
public class UserController {
    @FXML
    private Label account;


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
    protected void doLogout(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void setUtente(Utente utente){
        UserController.utente = utente;
        account.setText("Ciao " + utente.getNome() + ", questa è la tua area riservata.");
    }
}

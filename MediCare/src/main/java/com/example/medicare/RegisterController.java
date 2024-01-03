package com.example.medicare;

import DataTier.MediCare.Utente.Utente;
import DataTier.MediCare.Utente.UtenteDAO;
import LogicTier.MediCare.Registrazione.Registrazione;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.time.LocalDate;


public class RegisterController {

    @FXML
    private TextField fieldNome;
    @FXML
    private TextField fieldCognome;
    @FXML
    private TextField fieldEmail;
    @FXML
    private TextField fieldTelefono;
    @FXML
    private PasswordField fieldPassword;
    @FXML
    private DatePicker fieldDataDiNascita;
    @FXML
    private Label error;

    @FXML
    protected void onRegistratiButtonClick(){
        String nome = fieldNome.getText();
        String cognome = fieldCognome.getText();
        String email = fieldEmail.getText();
        String telefono = fieldTelefono.getText();
        String password = fieldPassword.getText();
        LocalDate dataDiNascita =  fieldDataDiNascita.getValue();

        Registrazione registrazione = new Registrazione();
        int result = registrazione.doRegistrazione(nome,cognome,email,password,telefono,dataDiNascita,error);

        //il valore di ritorno di registrazione indica per quale motivo la registrazione non è andata a buon fine
        switch(result){
            case 1: {
                error.setText("Nome non valido");
                throw new RuntimeException();
            }
            case 2: {
                error.setText("Cognome non valido");
                throw new RuntimeException();
            }
            case 3: {
                error.setText("Email non valida");
                throw new RuntimeException();
            }
            case 4: {
                error.setText("Password non valida");
                throw new RuntimeException();
            }
            case 5: {
                error.setText("Data di nascita non valida");
                throw new RuntimeException();
            }
            case 6: {
                error.setText("Numero di telefono non valido");
                throw new RuntimeException();
            }
            case 7: {
                error.setText("Utente già registrato");
                throw new RuntimeException();
            }
        }
    }
}
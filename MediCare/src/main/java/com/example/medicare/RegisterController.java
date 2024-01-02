package com.example.medicare;

import DataTier.MediCare.Utente.Utente;
import DataTier.MediCare.Utente.UtenteDAO;
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
        Utente u = new Utente();

        UtenteDAO uDao = new UtenteDAO();
        if(!u.setNome(nome)){
            error.setText("Nome non valido");
            throw new RuntimeException();
        }
        if (!u.setCognome(cognome)){
            error.setText("Cognome non valido");
            throw new RuntimeException();
        }
        if (!u.setEmail(email)){
            error.setText("Email non valida");
            throw new RuntimeException();
        }
        if (!u.setPassword(password)){
            error.setText("Password non valida");
            throw new RuntimeException();
        }
        if (!u.setDdn(dataDiNascita)){
            error.setText("Data di nascita non valida");
            throw new RuntimeException();
        }
        if (!u.setNumero(telefono)){
            error.setText("Numero di telefono non valido");
            throw new RuntimeException();
        }
        if(!uDao.doSave(u)){
            error.setText("Utente già registrato");
            throw new RuntimeException();
        }
    }
}
package com.example.medicare;

import DataTier.MediCare.Utente.Utente;
import DataTier.MediCare.Utente.UtenteDAO;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.GregorianCalendar;


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
    protected void onRegistratiButtonClick(){
        String nome = fieldNome.getText();
        String cognome = fieldCognome.getText();
        String email = fieldEmail.getText();
        String telefono = fieldTelefono.getText();
        String password = fieldPassword.getText();
        LocalDate dataDiNascita =  fieldDataDiNascita.getValue();
        Utente u = new Utente();
        u.setNome(nome);
        u.setCognome(cognome);
        u.setEmail(email);
        u.setPassword(password);
        u.setDdn(dataDiNascita);
        u.setNumero(telefono);
        UtenteDAO uDao = new UtenteDAO();
        uDao.doSave(u);
    }
}
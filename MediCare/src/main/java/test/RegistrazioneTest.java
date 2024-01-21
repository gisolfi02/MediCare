package test;

import DataTier.MediCare.Utente.Utente;
import DataTier.MediCare.Utente.UtenteDAO;
import LogicTier.MediCare.Registrazione.RegistrazioneLogic;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class RegistrazioneTest {
    RegistrazioneLogic reg = new RegistrazioneLogic();
    UtenteDAO userDAO = new UtenteDAO();
    @Test
    public void testRegistrazioneSenzaNome(){
        //crezione utente mock
        Utente u1 = new Utente();
        //check registrazione senza nome
        u1.setNome("");
        u1.setCognome("CognomeProva");
        u1.setEmail("nome@cognome.it");
        u1.setPassword("Password1?");
        u1.setNumero("3334455667");
        LocalDate birthDate = LocalDate.parse("1998-12-15");
        u1.setDdn(birthDate);
        reg.doRegistrazione(u1.getNome(), u1.getCognome(),u1.getEmail(), "Password1?", u1.getNumero(), u1.getDdn());
        Utente retrievedUser = userDAO.doRetrieveByEmailPassword("nome@cognome.it", "Password1?");
        assertNull(retrievedUser); //usiamo assertFalse in quanto il metodo isEmpty ritorna true se la stringa è vuota -> noi la vogliamo non vuota, quindi false.
    }



    //l'utente non viene inserito in quanto sono stati inseriti dei caratteri non ammessi nel nome
    @Test
    public void testRegistrazioneNomeCaratteriSpeciali(){
        Utente u2 = new Utente();
        UtenteDAO userDAO = new UtenteDAO();
        //check registrazione senza nome
        u2.setNome("Nome°§");
        u2.setCognome("Cognome");
        u2.setEmail("nome2@cognome.it");
        u2.setPassword("Password12?");
        u2.setNumero("3334455667");
        LocalDate birthDate = LocalDate.parse("1999-02-04");
        u2.setDdn(birthDate);
        reg.doRegistrazione(u2.getNome(), u2.getCognome(),u2.getEmail(),"Password12?", u2.getNumero(), u2.getDdn());
        Utente retrievedUser = userDAO.doRetrieveByEmailPassword("nome2@cognome.it", "Password12?");
        assertNull(retrievedUser); //usiamo assertFalse in quanto il metodo isEmpty ritorna true se la stringa è vuota -> noi la vogliamo non vuota, quindi false.
    }

    @Test
    public void testRegistrazioneCognomeVuoto(){
        Utente u3 = new Utente();
        UtenteDAO userDAO = new UtenteDAO();
        //check registrazione senza nome
        u3.setNome("Nome");
        u3.setCognome("");
        u3.setEmail("nome3@cognome.it");
        u3.setPassword("Password12?");
        u3.setNumero("3334455667");
        LocalDate birthDate = LocalDate.parse("1999-02-04");
        u3.setDdn(birthDate);
        reg.doRegistrazione(u3.getNome(), u3.getCognome(),u3.getEmail(),"Password12?", u3.getNumero(), u3.getDdn());
        Utente retrievedUser = userDAO.doRetrieveByEmailPassword("nome3@cognome.it", "Password12?");
        assertNull(retrievedUser); //usiamo assertFalse in quanto il metodo isEmpty ritorna true se la stringa è vuota -> noi la vogliamo non vuota, quindi false.
    }

    @Test
    public void testRegistrazioneCognomeErrato(){
        Utente u4 = new Utente();
        UtenteDAO userDAO = new UtenteDAO();
        //check registrazione senza nome
        u4.setNome("Nome");
        u4.setCognome("Cognome°§");
        u4.setEmail("nome4@cognome.it");
        u4.setPassword("Password12?");
        u4.setNumero("3334455667");
        LocalDate birthDate = LocalDate.parse("1999-02-04");
        u4.setDdn(birthDate);
        reg.doRegistrazione(u4.getNome(), u4.getCognome(),u4.getEmail(), "Password12?", u4.getNumero(), u4.getDdn());
        Utente retrievedUser = userDAO.doRetrieveByEmailPassword("nome4@cognome.it", "Password12?");
        assertNull(retrievedUser); //usiamo assertFalse in quanto il metodo isEmpty ritorna true se la stringa è vuota -> noi la vogliamo non vuota, quindi false
    }

    @Test
    public void testRegistrazioneNonMaggiorenne(){
        Utente u5 = new Utente();
        UtenteDAO userDAO = new UtenteDAO();
        //check registrazione senza nome
        u5.setNome("Nome");
        u5.setCognome("Cognome");
        u5.setEmail("nome5@cognome.it");
        u5.setPassword("Password12?");
        u5.setNumero("3334455667");
        LocalDate birthDate = LocalDate.parse("2008-02-04");
        u5.setDdn(birthDate);
        reg.doRegistrazione(u5.getNome(), u5.getCognome(),u5.getEmail(), "Password12?", u5.getNumero(), u5.getDdn());
        Utente retrievedUser = userDAO.doRetrieveByEmailPassword("nome5@cognome.it", "Password12?");
        assertNull(retrievedUser); //usiamo assertFalse in quanto il metodo isEmpty ritorna true se la stringa è vuota -> noi la vogliamo non vuota, quindi false.
    }


    @Test
    public void testRegistrazioneEmailInvalida(){
        Utente u6 = new Utente();
        UtenteDAO userDAO = new UtenteDAO();
        //check registrazione senza nome
        u6.setNome("Nome");
        u6.setCognome("Cognome");
        u6.setEmail("nome6cognome.ciao");
        u6.setPassword("Password12?");
        u6.setNumero("3334455667");
        LocalDate birthDate = LocalDate.parse("1999-02-04");
        u6.setDdn(birthDate);
        reg.doRegistrazione(u6.getNome(), u6.getCognome(),u6.getEmail(), "Password12?", u6.getNumero(), u6.getDdn());
        Utente retrievedUser = userDAO.doRetrieveByEmailPassword("nome6@cognome.it", "Password12?");
        assertNull(retrievedUser); //usiamo assertFalse in quanto il metodo isEmpty ritorna true se la stringa è vuota -> noi la vogliamo non vuota, quindi false.
    }


    @Test
    public void testRegistrazionePasswordInvalida(){
        Utente u7 = new Utente();
        UtenteDAO userDAO = new UtenteDAO();
        //check registrazione senza nome
        u7.setNome("Nome");
        u7.setCognome("Cognome");
        u7.setEmail("nome7@cognome.it");
        u7.setPassword("Pass12");
        u7.setNumero("3334455667");
        LocalDate birthDate = LocalDate.parse("1999-02-04");
        u7.setDdn(birthDate);
        reg.doRegistrazione(u7.getNome(), u7.getCognome(),u7.getEmail(), "Pass12", u7.getNumero(), u7.getDdn());
        Utente retrievedUser = userDAO.doRetrieveByEmailPassword("nome7@cognome.it", "Pass12");
        assertNull(retrievedUser); //usiamo assertFalse in quanto il metodo isEmpty ritorna true se la stringa è vuota -> noi la vogliamo non vuota, quindi false.
    }


    @Test
    public void testRegistrazioneCellulareErrato(){
        Utente u8 = new Utente();
        UtenteDAO userDAO = new UtenteDAO();
        //check registrazione senza nome
        u8.setNome("Nome");
        u8.setCognome("Cognome");
        u8.setEmail("nome8@cognome.it");
        u8.setPassword("Password12?");
        u8.setNumero("352452ò156");
        LocalDate birthDate = LocalDate.parse("1999-02-04");
        u8.setDdn(birthDate);
        reg.doRegistrazione(u8.getNome(), u8.getCognome(),u8.getEmail(), "Password12?", u8.getNumero(), u8.getDdn());
        Utente retrievedUser = userDAO.doRetrieveByEmailPassword("nome8@cognome.it", "Password12?");
        assertNull(retrievedUser); //usiamo assertFalse in quanto il metodo isEmpty ritorna true se la stringa è vuota -> noi la vogliamo non vuota, quindi false.
    }


    @Test
    public void testRegistrazioneEffettuata(){
        Utente u9 = new Utente();
        UtenteDAO userDAO = new UtenteDAO();
        //check registrazione senza nome
        u9.setNome("Nome");
        u9.setCognome("Cognome");
        u9.setEmail("nome9@cognome.it");
        u9.setPassword("Password12?");
        u9.setNumero("3334355667");
        LocalDate birthDate = LocalDate.parse("1999-02-04");
        u9.setDdn(birthDate);
        reg.doRegistrazione(u9.getNome(), u9.getCognome(),u9.getEmail(), "Password12?", u9.getNumero(), u9.getDdn());
        Utente retrievedUser = userDAO.doRetrieveByEmailPassword("nome9@cognome.it", "Password12?");
        assertNotNull(retrievedUser); //usiamo assertFalse in quanto il metodo isEmpty ritorna true se la stringa è vuota -> noi la vogliamo non vuota, quindi false.
    }





}

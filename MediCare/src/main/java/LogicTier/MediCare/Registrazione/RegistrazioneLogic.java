package LogicTier.MediCare.Registrazione;

import DataTier.MediCare.Utente.Utente;
import DataTier.MediCare.Utente.UtenteDAO;

import java.time.LocalDate;

/**
 * Classe che si occupa della logica della registrazione da parte di un utente
 */
public class RegistrazioneLogic {

    /**
     * Metodo che effettua la registrazione dell'utente richiamando la classe UtenteDAO
     *
     * @param nome  nome dell'utente
     * @param cognome  cognome dell'utente
     * @param email email dell'utente
     * @param password  password dell'utente
     * @param telefono  telefono dell'utente
     * @param dataDiNascita  data di nascita dell'utente
     * @return valore che indica se un campo del form non rispetta il suo formato o se la registrazione è andata a buon fine
     */
    public int doRegistrazione(String nome, String cognome, String email, String password, String telefono, LocalDate dataDiNascita) {
        Utente u = new Utente();
        UtenteDAO uDao = new UtenteDAO();


        if(!nome.matches("([A-Z][a-z]+)")){
            return 1;
        }
        if (!cognome.matches("([A-Z][a-z']+)")){
           return 2;
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
           return 3;
        }
        if (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")){
            return 4;
        }
        if (dataDiNascita ==null || LocalDate.now().getYear()-dataDiNascita.getYear()<18){
            return 5;
        }
        if (!telefono.matches("[0-9]{10}")){
            return 6;
        }


        u.setNome(nome);
        u.setCognome(cognome);
        u.setEmail(email);
        u.setPassword(password);
        u.setDdn(dataDiNascita);
        u.setNumero(telefono);


        if(!uDao.doSave(u)){
            return 7;
        }
        return 0;
    }
}

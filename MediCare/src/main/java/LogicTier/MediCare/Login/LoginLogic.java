package LogicTier.MediCare.Login;

import DataTier.MediCare.Utente.Utente;
import DataTier.MediCare.Utente.UtenteDAO;

/**
 * Classe che si occupa della logica del login da parte di un utente
 */
public class LoginLogic {

    /**
     * Metodo che effettua il loging dell'utente richiamando la classe UtenteDAO
     *
     * @param email  email per il login
     * @param password  password per il login
     * @return Utente
     */
    public Utente doLogin(String email, String password){
        UtenteDAO uDAO = new UtenteDAO();
        return uDAO.doRetrieveByEmailPassword(email,password);
    }
}

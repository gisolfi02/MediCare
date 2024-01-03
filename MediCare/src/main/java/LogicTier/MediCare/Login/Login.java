package LogicTier.MediCare.Login;

import DataTier.MediCare.Utente.Utente;
import DataTier.MediCare.Utente.UtenteDAO;

public class Login {

    public Utente doLogin(String email, String password){
        UtenteDAO uDAO = new UtenteDAO();
        Utente u = uDAO.doRetrieveByEmailPassword(email,password);
        return u;
    }
}

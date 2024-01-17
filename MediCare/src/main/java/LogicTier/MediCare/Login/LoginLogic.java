package LogicTier.MediCare.Login;

import DataTier.MediCare.Utente.Utente;
import DataTier.MediCare.Utente.UtenteDAO;

public class LoginLogic {

    public Utente doLogin(String email, String password){
        UtenteDAO uDAO = new UtenteDAO();
        return uDAO.doRetrieveByEmailPassword(email,password);
    }
}

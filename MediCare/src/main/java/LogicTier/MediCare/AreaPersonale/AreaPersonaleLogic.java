package LogicTier.MediCare.AreaPersonale;

import DataTier.MediCare.Utente.Utente;
import DataTier.MediCare.Utente.UtenteDAO;

/**
 * Classe che si occupa della gestione della logica dell'area personale
 */
public class AreaPersonaleLogic {

    /**
     * Metodo che occupa di eliminare l'account dall'applicazione
     * @param utente che ha richiesto la cancellazione dell'account
     */
    public void elimina(Utente utente){
         UtenteDAO utenteDAO = new UtenteDAO();
         utenteDAO.removeUtente(utente);
    }
}

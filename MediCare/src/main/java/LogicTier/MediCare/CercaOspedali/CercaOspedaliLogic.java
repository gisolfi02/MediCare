package LogicTier.MediCare.CercaOspedali;

import DataTier.MediCare.Ospedale.Ospedale;
import DataTier.MediCare.Ospedale.OspedaleDAO;

import java.util.ArrayList;

public class CercaOspedaliLogic {

    /**
     * Metodo che di cercare gli ospedali presenti nella località inserita dall'utente
     * @param ricerca località inserita dall'utente
     * @return lista di nome di ospedali e relativi indirizzi
     */
    public ArrayList<String> cercaOspedali(String ricerca){
        if(ricerca.isEmpty())
            return null;
        OspedaleDAO ospedaleDAO = new OspedaleDAO();
        ArrayList<Ospedale> ospedali = ospedaleDAO.doRetriveByRicerca(ricerca);
        ArrayList<String> nomeIndirizzi = new ArrayList<>();
        for(Ospedale o : ospedali){
            String temp = "- " + o.getNome() + ", " + o.getIndirizzo();
            nomeIndirizzi.add(temp);
        }
        return nomeIndirizzi;
    }
}

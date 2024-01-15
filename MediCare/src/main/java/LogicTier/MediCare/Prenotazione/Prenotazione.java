package LogicTier.MediCare.Prenotazione;

import DataTier.MediCare.Medico.Medico;
import DataTier.MediCare.Medico.MedicoDAO;
import DataTier.MediCare.Ospedale.Ospedale;
import DataTier.MediCare.Ospedale.OspedaleDAO;
import DataTier.MediCare.Reparto.Reparto;
import DataTier.MediCare.Reparto.RepartoDAO;

import java.util.ArrayList;

public class Prenotazione {
    private OspedaleDAO ospedaleDAO = new OspedaleDAO();
    private  RepartoDAO repartoDAO = new RepartoDAO();
    private MedicoDAO medicoDAO = new MedicoDAO();


    public ArrayList<String> getReparti(String nomeOspedale){
        String codice = nomeOspedale.split("-")[1];
        ArrayList<Reparto> reparti =  repartoDAO.doRetriveRepartiByCodice(codice);
        ArrayList<String> nomiReparto = new ArrayList<>();
        for(Reparto reparto : reparti){
            nomiReparto.add(reparto.getNome());
        }
        return nomiReparto;
    }
    public ArrayList<String> getComuni(){
        return ospedaleDAO.doRetriveComuni();
    }

    public ArrayList<String> getOspedali(String comune){
        ArrayList<Ospedale> ospedali = ospedaleDAO.doRetriveOspedaleByComune(comune);
        ArrayList<String> nomiOspedali = new ArrayList<>();
        for(Ospedale ospedale : ospedali){
            String nome = ospedale.getNome() + "-" + ospedale.getCodice();
            nomiOspedali.add(nome);
        }
        return nomiOspedali;
    }

    public ArrayList<String> getMedici(String reparto, String ospedale){
        String codice = ospedale.split("-")[1];
        ArrayList<Medico> medici = medicoDAO.doRetriveByRepartoOspedale(reparto,codice);
        ArrayList<String> nomiMedici = new ArrayList<>();
        for (Medico medico : medici){
            String nome = "Dott. " + medico.getNome() + " " + medico.getCognome() + "-" + medico.getId();
            nomiMedici.add(nome);
        }
        return nomiMedici;
    }
}

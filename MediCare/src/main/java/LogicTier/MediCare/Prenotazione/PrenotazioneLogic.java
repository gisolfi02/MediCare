package LogicTier.MediCare.Prenotazione;

import DataTier.MediCare.Medico.Medico;
import DataTier.MediCare.Medico.MedicoDAO;
import DataTier.MediCare.Ospedale.Ospedale;
import DataTier.MediCare.Ospedale.OspedaleDAO;
import DataTier.MediCare.Prenotazione.Prenotazione;
import DataTier.MediCare.Prenotazione.PrenotazioneDAO;
import DataTier.MediCare.Reparto.Reparto;
import DataTier.MediCare.Reparto.RepartoDAO;

import java.time.LocalDate;
import java.util.ArrayList;

public class PrenotazioneLogic {
    private OspedaleDAO ospedaleDAO = new OspedaleDAO();
    private RepartoDAO repartoDAO = new RepartoDAO();
    private MedicoDAO medicoDAO = new MedicoDAO();
    private PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();
    private Prenotazione prenotazione = new Prenotazione();


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

    public int doPrenotazione(String nome, String cognome, String cf, LocalDate data, String ora, String emailUtente, String medico, String ospedale){
        if(!nome.matches("([A-Z][a-z]+)") || nome.isBlank()){
            return 1;
        }
        if (!cognome.matches("([A-Z][a-z']+)") || cognome.isBlank()){
            return 2;
        }
        if(!cf.matches("[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]") || cf.isBlank()){
            return 3;
        }
        if (data == null || data.isBefore(LocalDate.now())){
            return 4;
        }
        if (ora == null){
            return 5;
        }
        int idMedico = Integer.parseInt(medico.split("-")[1]);
        int idOspedale = Integer.parseInt(ospedale.split("-")[1]);

        prenotazione.setNome(nome);
        prenotazione.setCognome(cognome);
        prenotazione.setCf(cf);
        prenotazione.setData(data);
        prenotazione.setOra(ora);
        prenotazione.setEmailUtente(emailUtente);
        prenotazione.setIdMedico(idMedico);
        prenotazione.setIdOspedale(idOspedale);

        return 0;
    }

    public boolean salvaPrenotazione(Prenotazione prenotazione){
        return prenotazioneDAO.doSave(prenotazione);
    }

    public Prenotazione getPrenotazione() {
        return prenotazione;
    }
}
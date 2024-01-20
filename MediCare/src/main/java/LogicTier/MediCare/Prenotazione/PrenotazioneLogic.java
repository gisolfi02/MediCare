package LogicTier.MediCare.Prenotazione;

import DataTier.MediCare.Medico.Medico;
import DataTier.MediCare.Medico.MedicoDAO;
import DataTier.MediCare.Ospedale.Ospedale;
import DataTier.MediCare.Ospedale.OspedaleDAO;
import DataTier.MediCare.Prenotazione.Prenotazione;
import DataTier.MediCare.Prenotazione.PrenotazioneDAO;
import DataTier.MediCare.Reparto.Reparto;
import DataTier.MediCare.Reparto.RepartoDAO;
import DataTier.MediCare.Utente.Utente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che si occupa della logica di tutto il sottosistema di prenotazione
 */
public class PrenotazioneLogic {
    private OspedaleDAO ospedaleDAO = new OspedaleDAO();
    private RepartoDAO repartoDAO = new RepartoDAO();
    private MedicoDAO medicoDAO = new MedicoDAO();
    private PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();
    private Prenotazione prenotazione = new Prenotazione();


    /**
     * Metodo che restituisce un medico in base al suo id
     * @param id  id del medico
     * @return Medico
     */
    public Medico getMedico(int id) {
        return medicoDAO.doRetriveById(id);
    }

    /**
     * Metodo che restituisce la lista dei nomi dei medici che appartengono a un deteterminato reparto di un determinato ospedale
     * @param reparto  nome del reparto
     * @param ospedale  nome dell'ospedale
     * @return lista dei nomi dei medici
     */
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


    /**
     * Metodo che restituisce la lista dei reparti di un determinato ospedale
     * @param nomeOspedale  nome dell'ospedale
     * @return lista di reparti
     */
    public ArrayList<String> getReparti(String nomeOspedale){
        String codice = nomeOspedale.split("-")[1];
        ArrayList<Reparto> reparti =  repartoDAO.doRetriveRepartiByCodice(codice);
        ArrayList<String> nomiReparto = new ArrayList<>();
        for(Reparto reparto : reparti){
            nomiReparto.add(reparto.getNome());
        }
        return nomiReparto;
    }


    /**
     * Metodo che ritorna un ospedale in base al suo id
     * @param id  id dell'ospedale
     * @return Ospedale
     */
    public Ospedale getOspedale(int id){
        return ospedaleDAO.doRetrieveById(id);
    }

    /**
     * Metodo che restituisce la lista dei nomi degli ospedali in un determinato comune
     * @param comune  nome del comune
     * @return lista di ospedali
     */
    public ArrayList<String> getOspedali(String comune){
        ArrayList<Ospedale> ospedali = ospedaleDAO.doRetriveOspedaleByComune(comune);
        ArrayList<String> nomiOspedali = new ArrayList<>();
        for(Ospedale ospedale : ospedali){
            String nome = ospedale.getNome() + "-" + ospedale.getCodice();
            nomiOspedali.add(nome);
        }
        return nomiOspedali;
    }


    /**
     * Metodo che restituisce la lsita dei comuni presenti nel database
     * @return lista di comuni
     */
    public ArrayList<String> getComuni(){
        return ospedaleDAO.doRetriveComuni();
    }


    /**
     * Metodo che restituisce le ore disponibili per la prenotazione per un determinato medico in un determinato giorno
     * @param data data in cui si vuole effettuare la prenotazione
     * @param medico stringa contentente nome e id del medico
     * @return lista di ore disponibili per la prenotazione
     */
    public ArrayList<String> getOre(LocalDate data, String medico){
        int idMedico = Integer.parseInt(medico.split("-")[1]);
        ArrayList<String> ore = new ArrayList<>();
        ore.addAll(List.of(new String[]{"09-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16", "16-17", "17-18"}));
        ArrayList<String> oreNonDisp = prenotazioneDAO.doRetriveOreDisp(data,idMedico);
        for (String ora : oreNonDisp){
            ore.remove(ora);
        }
        return ore;
    }


    /**
     * Metodo che si occupa di effettuare la prenotazione di un paziente per un determinato medico
     * @param nome nome del paziente
     * @param cognome cognome del paziente
     * @param cf codice fiscale del paziente
     * @param data data della prenotazione
     * @param ora ora della prenotazione
     * @param emailUtente email dell'utente che sta effettuando la prenotazione
     * @param medico medico presso cui effettuare la prenotazione
     * @param ospedale  ospedale in cui fare la prenotazione
     * @return intero che indica se un campo della prenotazione non rispetta il formato richiesto oppure se la prenotazione può essere effettuata
     */
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


    /**
     * Metodo che si occupa di memorizzare la prenotazione
     * @param prenotazione
     * @return valore booleano che indica se il salvataggio è andato a buon fine o meno
     */
    public boolean salvaPrenotazione(Prenotazione prenotazione){
        return prenotazioneDAO.doSave(prenotazione);
    }


    /**
     * Metodo che restituisce la prenotazione appena effettuata
     * @return prenotazione
     */
    public Prenotazione getPrenotazione() {
        return prenotazione;
    }


    /**
     * Metodo che restituisce la lista delle prenotazioni effettuate da un utente specifico
     * @param u untente da cui ricavare le prenotazioni
     * @return lista delle prenotazioni dell'utente
     */
    public ArrayList<Prenotazione> getPrenotazioni(Utente u){
        return prenotazioneDAO.doRetrivePrenotazioniByUtente(u);
    }
}

package DataTier.MediCare.Prenotazione;


import java.time.LocalDate;

/**
 * Classe che rappresenta un Prenotazione presso un medico di un ospedale
 */
public class Prenotazione {

    private int codice;
    private LocalDate data;
    private String ora;
    private String nome;
    private String cognome;
    private String cf;
    private String emailUtente;
    private int idMedico;
    private int idOspedale;

    /**
     * @return restituisce il nome del paziente
     */
    public String getNome() {
        return nome;
    }

    /**
     * imposta il nome del paziente
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return restituisce il cognome del paziente
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * imposta il cognome del paziente
     * @param cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return restituisce il codice fiscale del paziente
     */
    public String getCf() {
        return cf;
    }

    /**
     * imposta il codice fiscale del paziente
     * @param cf
     */
    public void setCf(String cf) {
        this.cf = cf;
    }

    /**
     * @return restituisce il codice della prenotazione
     */
    public int getCodice() {
        return codice;
    }

    /**
     * imposta il codice della prenotazione
     * @param codice
     */
    public void setCodice(int codice) {
        this.codice = codice;
    }

    /**
     * @return restituisce la data della prenotazione
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * imposta la data della prenotazione
     * @param data
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * @return restituisce l'ora della prenotazione
     */
    public String getOra() {
        return ora;
    }

    /**
     * imposta l'ora della prenotazione
     * @param ora
     */
    public void setOra(String ora) {
        this.ora = ora;
    }

    /**
     * @return restituisce l'email dell'utente che ha effettuato la prenotazione
     */
    public String getEmailUtente() {
        return emailUtente;
    }

    /**
     * imposta l'email dell'utente che ha effettuato la prenotazione
     * @param emailUtente
     */
    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }

    /**
     * @return restituisce l'id del medico della prenotazione
     */
    public int getIdMedico() {
        return idMedico;
    }

    /**
     * imposta l'id del medico della prenotazione
     * @param idMedico
     */
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    /**
     * @return restituisce l'id dell'ospedale della prenotazione
     */
    public int getIdOspedale() {
        return idOspedale;
    }

    /**
     * imposta l'id dell'ospedale della prenotazione
     * @param idOspedale
     */
    public void setIdOspedale(int idOspedale) {
        this.idOspedale = idOspedale;
    }
}

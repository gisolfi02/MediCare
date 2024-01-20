package DataTier.MediCare.Medico;

import java.time.LocalDate;


/**
 * Classe che rappresenta un medico
 */
public class Medico {

    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String nomeReparto;
    private int idOspedale;

    /**
     * @return restituisce l'id del medico
     */
    public int getId() {
        return id;
    }

    /**
     * imposta l'id del medico
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return restituisce il nome del medico
     */
    public String getNome() {
        return nome;
    }

    /**
     * imposta il nome del medico
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return restituisce il cognome del medico
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * imposta il cognome del medico
     * @param cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return restituisce l'email del medico
     */
    public String getEmail() {
        return email;
    }

    /**
     * imposta l'email del medico
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return restituisce la data di nascita del medico
     */
    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    /**
     * imposta la data di nascita del medico
     * @param dataDiNascita
     */
    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    /**
     * @return restituisce il nome del reparto in cui lavora il medico
     */
    public String getNomeReparto() {
        return nomeReparto;
    }

    /**
     * imposta il nome del reparto in cui lavora il medico
     * @param nomeReparto
     */
    public void setNomeReparto(String nomeReparto) {
        this.nomeReparto = nomeReparto;
    }

    /**
     * @return restituisce l'id dell'ospedale in cui lavora il medico
     */
    public int getIdOspedale() {
        return idOspedale;
    }

    /**
     * imposta l'id dell'ospedale in cui lavora il medico
     * @param idOspedale
     */
    public void setIdOspedale(int idOspedale) {
        this.idOspedale = idOspedale;
    }
}

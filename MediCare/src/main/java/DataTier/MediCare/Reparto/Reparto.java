package DataTier.MediCare.Reparto;

/**
 * Classe che rappresenta un reparto di un ospedale
 */
public class Reparto {
    private String nome;
    private  int idOspedale;
    private int postiDisp;
    private int personale;

    /**
     *
     * @return restituisce il nome del reparto
     */
    public String getNome() {
        return nome;
    }

    /**
     * imposta il nome del reparto
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return restituisce l'id dell'ospedale a cui appartiene
     */
    public int getIdOspedale() {
        return idOspedale;
    }

    /**
     * imposta l'id dell'ospedale a cui appartiene
     * @param idOspedale
     */
    public void setIdOspedale(int idOspedale) {
        this.idOspedale = idOspedale;
    }

    /**
     * @return restituisce i posti disponibili nel reparto
     */
    public int getPostiDisp() {
        return postiDisp;
    }

    /**
     * imposta i posti disponibili nel reparto
     * @param postiDisp
     */
    public void setPostiDisp(int postiDisp) {
        this.postiDisp = postiDisp;
    }

    /**
     * @return restituisce il numero di personale presente nel reparto
     */
    public int getPersonale() {
        return personale;
    }

    /**
     * imposta il numero di personale prensente nel reparto
     * @param personale
     */
    public void setPersonale(int personale) {
        this.personale = personale;
    }
}

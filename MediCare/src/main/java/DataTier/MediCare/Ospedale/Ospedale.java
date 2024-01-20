package DataTier.MediCare.Ospedale;

/**
 * Classe che rappresenta un ospedale
 */
public class Ospedale {
    private int codice;
    private String nome;
    private String paese;
    private String indirizzo;

    /**
     * @return restituisce l'id dell'ospedale
     */
    public int getCodice() {
        return codice;
    }

    /**
     * imposta l'id dell'ospedale
     * @param codice
     */
    public void setCodice(int codice) {
        this.codice = codice;
    }

    /**
     * @return restituisce il nome dell'ospedale
     */
    public String getNome() {
        return nome;
    }

    /**
     * imposta il nome dell'ospedale
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return restituisce il comune in cui si trova l'ospedale
     */
    public String getPaese() {
        return paese;
    }

    /**
     * imposta il comune in sui si trova l'ospedale
     * @param paese
     */
    public void setPaese(String paese) {
        this.paese = paese;
    }

    /**
     * @return restituisce l'indirizzo dell'ospedale
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * imposta l'indirizzo dell'ospedale
     * @param indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}

package DataTier.MediCare.Prenotazione;


import java.time.LocalDate;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }
    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getEmailUtente() {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdOspedale() {
        return idOspedale;
    }

    public void setIdOspedale(int idOspedale) {
        this.idOspedale = idOspedale;
    }
}

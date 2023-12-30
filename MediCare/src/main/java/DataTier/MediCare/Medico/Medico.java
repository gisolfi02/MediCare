package DataTier.MediCare.Medico;

import java.util.GregorianCalendar;

public class Medico {

    private int id;
    private String nome;
    private String cognome;
    private String email;
    private GregorianCalendar dataDiNascita;
    private String nomeReparto;
    private String nomeOspedale;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GregorianCalendar getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(GregorianCalendar dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getNomeReparto() {
        return nomeReparto;
    }

    public void setNomeReparto(String nomeReparto) {
        this.nomeReparto = nomeReparto;
    }

    public String getNomeOspedale() {
        return nomeOspedale;
    }

    public void setNomeOspedale(String nomeOspedale) {
        this.nomeOspedale = nomeOspedale;
    }
}

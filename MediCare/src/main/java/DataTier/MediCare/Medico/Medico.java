package DataTier.MediCare.Medico;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Medico {

    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String nomeReparto;
    private int idOspedale;

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

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getNomeReparto() {
        return nomeReparto;
    }

    public void setNomeReparto(String nomeReparto) {
        this.nomeReparto = nomeReparto;
    }

    public int getIdOspedale() {
        return idOspedale;
    }

    public void setIdOspedale(int idOspedale) {
        this.idOspedale = idOspedale;
    }
}

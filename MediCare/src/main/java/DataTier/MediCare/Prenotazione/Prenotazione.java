package DataTier.MediCare.Prenotazione;

import java.time.LocalTime;
import java.util.GregorianCalendar;

public class Prenotazione {

    private int codice;
    private GregorianCalendar data;
    private LocalTime ora;
    private String emailUtente;
    private int idMedico;
    private int idOspedale;


    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
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

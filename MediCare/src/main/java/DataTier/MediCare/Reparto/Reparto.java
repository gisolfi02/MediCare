package DataTier.MediCare.Reparto;

public class Reparto {
    private String nome;
    private String emailOspedale;
    private int postiDisp;
    private int personale;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailOspedale() {
        return emailOspedale;
    }

    public void setEmailOspedale(String emailOspedale) {
        this.emailOspedale = emailOspedale;
    }

    public int getPostiDisp() {
        return postiDisp;
    }

    public void setPostiDisp(int postiDisp) {
        this.postiDisp = postiDisp;
    }

    public int getPersonale() {
        return personale;
    }

    public void setPersonale(int personale) {
        this.personale = personale;
    }
}

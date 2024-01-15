package DataTier.MediCare.Reparto;

public class Reparto {
    private String nome;
    private  int idOspedale;
    private int postiDisp;
    private int personale;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdOspedale() {
        return idOspedale;
    }

    public void setIdOspedale(int idOspedale) {
        this.idOspedale = idOspedale;
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

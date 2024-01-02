package DataTier.MediCare.Utente;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class Utente {
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private LocalDate ddn; //usato localdate perché è il valore che viene da javafx + per portarlo a sql.Date basta fare valueof (vedi in utenteDAO)
    private String numero;

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            this.email = email;
            return true;
        }
        else
            return false;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if(password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-.]).{8,}$")) {
            try {
                MessageDigest digest =
                        MessageDigest.getInstance("SHA-1");
                digest.reset();
                digest.update(password.getBytes(StandardCharsets.UTF_8));
                this.password = String.format("%040x", new
                        BigInteger(1, digest.digest()));
                return true;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        else
            return false;
    }

    public String getNome() {
        return nome;
    }

    // i valori boolean stanno per: true: regex rispettata, valore accettato - false: regex non rispettata, valore non accettato
    public boolean setNome(String nome) {
        if(nome.matches("([A-Z][a-z]+)")) {
            this.nome = nome;
            return true;
        }
        else
            return false;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean setCognome(String cognome) {

        if(cognome.matches("([A-Z][a-z']+)")) {
            this.cognome = cognome;
            return true;
        }
        else
            return false;
    }

    public LocalDate getDdn() {
        return ddn;
    }

    public boolean setDdn(LocalDate ddn) {
        LocalDate d = LocalDate.now();
        if(ddn==null || d.getYear()-ddn.getYear()< 18) {
            return false;
        }
        this.ddn = ddn;
        return true;
    }

    public String getNumero() {
        return numero;
    }

    public boolean setNumero(String numero) {
        if(numero.matches("[0-9]{10}")) {
            this.numero = numero;
            return true;
        }
        else
            return false;
    }
}
